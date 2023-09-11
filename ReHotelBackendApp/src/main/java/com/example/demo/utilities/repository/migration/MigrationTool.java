package com.example.demo.utilities.repository.migration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MigrationTool implements InitializingBean {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public MigrationTool() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Migrator start");

        doMigration();
        logger.info("Migrator finish");
    }

    private void doMigration() {
        int currentVersion = getCurrentVersion();
        logger.info("Doing migrations, currentVersion {}, Migrations.LAST_VERSION {}", currentVersion, Migrations.LAST_VERSION);


        if(Migrations.LAST_VERSION < currentVersion){
            String msg = String.format("Current version %s is greater than Migrations.LAST_VERSION %s, abort. Cannot downgrade",
                    currentVersion, Migrations.LAST_VERSION);
            logger.info(msg);
            throw new RuntimeException(msg);
        }

        List<Migration> migrations = Migrations.migrations;
        for (Migration migration : migrations) {
            applyMigration(migration);
        }

        int newCurrentVersion = getCurrentVersion();
        logger.info("Done migrations, newCurrentVersion {}, Migrations.LAST_VERSION {}", newCurrentVersion, Migrations.LAST_VERSION);
        if(newCurrentVersion != Migrations.LAST_VERSION){
            String msg = String.format("Current version %s is different than Migrations.LAST_VERSION %s, abort. All migrations passed but something is still wrong",
                    newCurrentVersion, Migrations.LAST_VERSION);
            logger.info(msg);
            throw new RuntimeException(msg);
        }

    }

    private void applyMigration(Migration migration) {
        int currentVersion = getCurrentVersion();
        logger.info("Applying migration, currentVersion {}, migration {}", currentVersion, migration);

        if(migration.from() < currentVersion){
            logger.info("Current version does not match migration.from(), ignoring migration");
            return;
        }

        if(currentVersion < migration.from()){
            String msg = String.format("Current version %s is less than migration.from() %s, abort. Probably missing intermediate migration",
                    currentVersion, migration.from());
            logger.info(msg);
            throw new RuntimeException(msg);
        }

        logger.info("Running migration...");
        try {
            migration.action().migrate(jdbcTemplate);
        } catch (Exception e) {
            logger.error("Error on migration " + e.getMessage());
            throw new RuntimeException(e);
        }
        logger.info("Migration successful");

        saveCurrentVersion(migration.to());
    }

    private int getCurrentVersion(){
        @SuppressWarnings("DataFlowIssue")
        boolean tableExist = isVersionTableExist();
        if(!tableExist) return 0;

        @SuppressWarnings("DataFlowIssue")
        int version = jdbcTemplate.queryForObject("SELECT version FROM version", Integer.class);

        if(version == 0) {
            logger.error("Version stored is zero");
            throw new RuntimeException("Version stored in dbis zero");
        }

        return version;
    }

    private void saveCurrentVersion(int version){
        logger.info("Updating current version to " + version);

        boolean tableExist = isVersionTableExist();
        if(tableExist){
            jdbcTemplate.update("UPDATE version SET version=?", version);
        } else {
            jdbcTemplate.update("CREATE TABLE version (version INTEGER)");
            jdbcTemplate.update("INSERT INTO version (version) values (?)", version);
        }
    }



    private Boolean isVersionTableExist() {
        return jdbcTemplate.queryForObject("""
                        SELECT EXISTS (
                            SELECT FROM
                                pg_tables
                            WHERE
                                schemaname = 'public' AND
                                tablename  = 'version'
                            );"""
                , Boolean.class);
    }
}

