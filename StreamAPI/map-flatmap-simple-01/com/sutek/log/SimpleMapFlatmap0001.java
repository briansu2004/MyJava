package com.sutek.log;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.IOException;

class SimpleMapFlatmap0001 {
    static Logger logger = Logger.getLogger(SimpleMapFlatmap0001.class.getName());

    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("mylogging.properties"));
        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
        }

        try {
            Map<String, List<String>> people = new HashMap<>();
            people.put("John", Arrays.asList("555-1123", "555-3389"));
            people.put("Mary", Arrays.asList("555-2243", "555-5264"));
            people.put("Steve", Arrays.asList("555-6654", "555-3242"));

            List<String> phones = people.values().stream()
                    .flatMap(Collection::stream).toList();

            phones.forEach(p -> logger.info(p));
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

}