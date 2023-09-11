package com.example.demo.utilities.repository.migration;

import org.slf4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public interface MigrationAction {

    void migrate(JdbcTemplate jdbc) throws Exception;

}
