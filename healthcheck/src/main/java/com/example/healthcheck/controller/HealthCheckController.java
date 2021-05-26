package com.example.healthcheck.controller;

import com.example.healthcheck.config.HealthCheckSetting;
import com.example.healthcheck.model.Employee;
import com.example.healthcheck.service.HealthCheckService;
import com.example.healthcheck.util.Helper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * /healthcheck?format=short
 * ==>
 * { "Status": "OK" }
 *
 * /healthcheck?format=long
 * ==>
 * { "Status": "OK", "Time": "2021-05-25T14:06:30Z" }
 *
 * Otherwise:
 * 400 (Bad Request)
 */
@RestController
public class HealthCheckController {
    Helper helper = new Helper();

    @RequestMapping(value = {"/healthcheck"}, produces = {"application/json"})
    public ResponseEntity HealthCheck(@RequestParam(value = "format", defaultValue = "short") String fmt) {
        try {
            String f = helper.getString(fmt).toLowerCase();

            if (!f.equals(HealthCheckSetting.FORMAT_SHORT) && !f.equals(HealthCheckSetting.FORMAT_LONG)) {
                //Invalid
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please use proper format");
            }

            //Valid
            HealthCheckService healthCheckService = new HealthCheckService();
            String res = healthCheckService.GetHealthCheckResponse(f);

            return ResponseEntity.status(HttpStatus.OK).body(res);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @RequestMapping(value = "/employee/{id}", produces = {"application/json"})
    public @ResponseBody
    Employee getEmployeeById(@PathVariable long empId) {
        Employee emp = new Employee();

        emp.setName("emp" + String.valueOf(empId));
        emp.setDesignation("manager");
        emp.setEmpId(empId);
        emp.setSalary(15000);

        return emp;
    }
}
