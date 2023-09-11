package com.example.demo.tools.datetime;

import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeHelper
{

    public static String toNiceString(ZonedDateTime zdt){
        return format(zdt, "yyyy-MM-dd HH:mm:ss Z");
    }

    public static String format(ZonedDateTime zdt, String format) {
        return format(zdt, DateTimeFormatter.ofPattern(format), Locale.getDefault());
    }

    public static String format(ZonedDateTime zdt, DateTimeFormatter formatter, Locale locale) {
        return zdt.format(formatter.withLocale(locale));
    }

    public static String format(Instant instant, ZoneId zoneId, String format){
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
        return format(zdt, DateTimeFormatter.ofPattern(format), Locale.getDefault());
    }


    public static final String pattern_yyyyMMddHHmmssSSSX = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
    public static final String pattern_yyyyMMddHHmmssSSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String pattern_yyyyMMddHHmmssZ = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static ZonedDateTime parseFormatUnsafe(String str, String format) {
        try {
            return parseFormat(str, format);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static ZonedDateTime parseFormat(String str, String format) throws ParseException {
        return ZonedDateTime.parse(str, DateTimeFormatter.ofPattern(format));
    }


    public static String toNiceString(Duration duration){
        return String.format("%d days, %02d hours, %02d mins, %02d sec",
                duration.toDays(),
                duration.toHoursPart(),
                duration.toMinutesPart(),
                duration.toSecondsPart());
    }
}
