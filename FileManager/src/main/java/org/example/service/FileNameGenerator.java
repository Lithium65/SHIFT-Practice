package org.example.service;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public final class FileNameGenerator {

    private FileNameGenerator() {
    }

    public static String generateFileName(ZoneId zoneId) {
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        String zoneSuffix = zoneId.getId().replace("/", "_");
        return timestamp + zoneSuffix + ".txt";
    }

}

