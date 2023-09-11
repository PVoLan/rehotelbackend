package ru.pvolan.rehotelbackend.utilities.repository.config;

import ru.pvolan.rehotelbackend.profiles.Profiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile(Profiles.VS_LOCAL)
public class VSLocalDataSourceConfiguration{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public DataSource getDataSource() {
        logger.info("Applying VSLocalDataSourceConfiguration");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/rehoteldb");
        dataSourceBuilder.username("rehoteluser");
        dataSourceBuilder.password("rehotelpassword");
        return dataSourceBuilder.build();
    }
}
