package ru.pvolan.rehotelbackend.utilities.repository.migration;

import org.springframework.jdbc.core.JdbcTemplate;

public interface MigrationAction {

    void migrate(JdbcTemplate jdbc) throws Exception;

}
