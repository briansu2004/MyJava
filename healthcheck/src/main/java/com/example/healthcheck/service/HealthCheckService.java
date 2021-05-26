package com.example.healthcheck.service;

import com.example.healthcheck.config.HealthCheckSetting;
import com.example.healthcheck.model.HealthCheckResponse;
import com.example.healthcheck.util.Helper;
import com.google.gson.Gson;

public class HealthCheckService {
    Helper helper = new Helper();

    public String GetHealthCheckResponse(String fmt) {
        HealthCheckResponse healthCheckResponse = new HealthCheckResponse();

        Gson gson = new Gson();

        if (fmt.equals(HealthCheckSetting.FORMAT_SHORT)) {
            healthCheckResponse.setStatus("OK");
        } else if (fmt.equals(HealthCheckSetting.FORMAT_LONG)) {
            healthCheckResponse.setStatus("OK");
            healthCheckResponse.setCurrentTime(helper.getRFC3339());
        }

        return gson.toJson(healthCheckResponse);
    }
}
