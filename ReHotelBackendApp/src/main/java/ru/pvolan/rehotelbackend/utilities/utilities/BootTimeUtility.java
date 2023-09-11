package ru.pvolan.rehotelbackend.utilities.utilities;

import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class BootTimeUtility {

    private final ZonedDateTime bootTime = ZonedDateTime.now();

    public ZonedDateTime getBootTime() {
        return bootTime;
    }
}
