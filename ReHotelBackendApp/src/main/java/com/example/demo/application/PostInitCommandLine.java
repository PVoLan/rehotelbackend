package com.example.demo.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Component;

@Component
public class PostInitCommandLine implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BuildProperties buildProperties;

    @Override
    public void run(String... args) throws Exception {
        logger.info("******** Initialized spring demo version {} ********", buildProperties.getVersion());
    }
}
