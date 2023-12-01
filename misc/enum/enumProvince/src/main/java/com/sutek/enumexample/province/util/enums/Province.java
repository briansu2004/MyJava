package com.sutek.enumexample.province.util.enums;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum Province {
    ON("Ontario",                  "Ontario"),
    QC("Quebec",                   "Québec"),
    NS("Nova Scotia",              "Nouvelle-Écosse"),
    NB("New Brunswick",            "Nouveau-Brunswick"),
    MB("Manitoba",                 "Manitoba"),
    BC("British Columbia",         "Colombie-Britannique"),
    PE("Prince Edward Island",     "Île-du-Prince-Édouard"),
    SK("Saskatchewan",             "Saskatchewan"),
    AB("Alberta",                  "Alberta"),
    NL("Newfoundland and Labrador","Terre-Neuve-et-Labrador"),
    NT("Northwest Territories",    "Territoires du Nord-Ouest"),
    YT("Yukon",                    "Yukon"),
    NU("Nunavut",                  "Nunavut");

    private final Map<Locale, String> names;

    Province(String englishName, String frenchName) {
        this.names = new HashMap<>();
        this.names.put(Locale.ENGLISH, englishName);
        this.names.put(Locale.FRENCH, frenchName);
    }

    public String getName() {
        Locale currentLocale = Locale.getDefault();
        return names.getOrDefault(currentLocale, names.get(Locale.ENGLISH));
    }

    public static Province getByCode(String code) {
        for (Province province : values()) {
            if (province.name().equalsIgnoreCase(code)) {
                return province;
            }
        }
        return null;
    }
}
