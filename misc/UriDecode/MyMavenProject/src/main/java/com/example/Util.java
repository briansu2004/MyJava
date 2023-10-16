package com.example;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.web.util.UriUtils;

public class Util {
    private Util() {
        throw new IllegalStateException("Utility class");
    }

    // Decode the parameters
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
}
