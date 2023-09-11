package com.example.demo.utilities.repository.config;

import com.example.demo.profiles.Profiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;


@Configuration
@Profile(Profiles.PROD)
public class ProdDataSourceConfiguration {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public DataSource getDataSource() {
        logger.info("Applying ProdDataSourceConfiguration");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/rehoteldb");
        dataSourceBuilder.username("rehoteluser");
        dataSourceBuilder.password("abvofkrkbd"); //Prod config does not listen connections from outside localhost, so it is safe
        return dataSourceBuilder.build();
    }
}
