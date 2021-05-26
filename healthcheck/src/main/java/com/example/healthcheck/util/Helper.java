package com.example.healthcheck.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    public String getString(String input) {
        if (input == null) {
            return null;
        }

        return input.trim();
    }

    public String getRFC3339() {
        return new SimpleDateFormat("yyyy-MM-dd'T'h:m:ss'Z'").format(new Date());
    }
}
