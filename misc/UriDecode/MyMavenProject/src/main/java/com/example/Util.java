package com.example;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.web.util.UriUtils;

public class Util {


    // Decode the parameters
    // Typically used for GET endpoints
    public static String decodeUrlParameter(String parameter) {
        return decodeUrlParameter(parameter, AppConstants.DEFAULT_ENCODING);
    }

    public static String decodeUrlParameter(String parameter, String encoding) {
        try {
            return UriUtils.decode(parameter, encoding);
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalDate convertString2LocalDate(String timestampString) {
        try {
            long timestamp = Long.parseLong(timestampString);
            Instant instant = Instant.ofEpochMilli(timestamp);
            ZoneId zoneId = ZoneId.of("UTC");
            LocalDate localDate = instant.atZone(zoneId).toLocalDate();
            return localDate;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String convertDate2String(Date date) {
        try {
            // Create a SimpleDateFormat with the desired output format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Format the date and store it as a string
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }
}
