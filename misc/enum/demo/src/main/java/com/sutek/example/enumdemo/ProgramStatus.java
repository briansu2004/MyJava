package com.sutek.example.enumdemo;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.commons.lang3.StringUtils;

public enum ProgramStatus {
    ENROLLED("Y"), NOT_ENROLLED("N"), DO_NOT_ENROL("D");

    private final String value;

    ProgramStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ProgramStatus match(String value) {
        for (ProgramStatus status : values()) {
            if (StringUtils.equalsIgnoreCase(status.getValue(), value)) {
                return status;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
