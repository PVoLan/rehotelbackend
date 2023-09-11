package com.example.demo.usecases;

import com.example.demo.entities.User;
import com.example.demo.tools.datetime.DateTimeHelper;
import com.example.demo.utilities.repository.user.UserRepository;
import com.example.demo.utilities.utilities.BootTimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

@Component
public class HelloControllerUC {

    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private UserRepository userRepository;
    @Autowired private BuildProperties buildProperties;
    @Autowired private BootTimeUtility bootTimeUtility;

    ///////////////////////////////////////////////////////////////////////////
    // Hello
    ///////////////////////////////////////////////////////////////////////////

    public HelloResponse hello(String name) throws Exception {

        ZonedDateTime bootTime = bootTimeUtility.getBootTime();
        Duration uptime = Duration.between( bootTime , ZonedDateTime.now() );

        return new HelloResponse(
                buildProperties.getArtifact(),
                buildProperties.getVersion(),
                DateTimeHelper.toNiceString(bootTime),
                DateTimeHelper.toNiceString(uptime)
        );
    }

    public record HelloResponse(
            String artifact,
            String version,
            String bootTime,
            String upTime
    ){}


    ///////////////////////////////////////////////////////////////////////////
    // Users
    ///////////////////////////////////////////////////////////////////////////


    public UsersResponse getUsers(){
        List<User> users = userRepository.getAllUsers();
        return new UsersResponse(users);
    }

    public record UsersResponse(
            List<User> users
    ){}
}
