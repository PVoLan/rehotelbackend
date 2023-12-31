package ru.pvolan.rehotelbackend.application;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    public void customize(ConfigurableServletWebServerFactory factory){
        factory.setPort(7879);
    }
}
