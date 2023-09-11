package ru.pvolan.rehotelbackend.utilities.repository.migration.migrations;

import ru.pvolan.rehotelbackend.utilities.repository.migration.MigrationAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class MigrationAction000to001 implements MigrationAction {


    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void migrate(JdbcTemplate jdbc) throws Exception {
        logger.info("Migration start");

        logger.info("Migration - create table users");

        jdbc.execute("""
                CREATE TABLE users (
                    id TEXT PRIMARY KEY,
                    name TEXT NOT NULL
                );
                """);

        logger.info("Migration - insert sample users");

        jdbc.execute("""
                INSERT INTO users (id, name) VALUES
                    ('asd','John'),
                    ('zxc','Mary');
                """);

        logger.info("Migration finish");
    }
}
