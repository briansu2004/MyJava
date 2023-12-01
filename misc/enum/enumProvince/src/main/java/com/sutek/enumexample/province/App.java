package com.sutek.enumexample.province;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.sutek.enumexample.province.bo.Provider;
import com.sutek.enumexample.province.bo.UIN;
import com.sutek.enumexample.province.util.enums.Province;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        List<Province> provinceList = retrieveProvinces();

        Provider provider = getMockProvider();

        transformUIN(provider, provinceList);

        System.out.println("Nice!");
    }

    private static List<Province> retrieveProvinces() {
        List<Province> provinceList = new ArrayList<>();
        Collections.addAll(provinceList, Province.values());
        return provinceList;
    }

    private static Provider getMockProvider() {
        Provider provider = new Provider();

        // mock data
        UIN u1 = new UIN("XY", "ON", "123");
        UIN u2 = new UIN("GH", "QC", "5436");
        UIN u3 = new UIN("KL", "AB", "33455");

        List<UIN> mockUINs = new ArrayList<>();
        mockUINs.add(u1);
        mockUINs.add(u2);
        mockUINs.add(u3);

        provider.setUin(mockUINs);

        return provider;
    }

    private static void transformUIN(Provider provider, List<Province> provinceList) {
        List<UIN> lstUIN = provider.getUin();

        // Update province values based on provinceList
        for (UIN uin : lstUIN) {
            Province matchingProvince = findProvinceByCode(provinceList, uin.getProvince());
            if (matchingProvince != null) {
                uin.setProvince(matchingProvince.getName());
            }
        }

        // Using forEach with lambda expression to print each element
        // lstUIN.forEach(uin -> System.out.println(uin));
        lstUIN.forEach(uin -> {
            String provinceName = uin.getProvince();
            System.out.println("UIN: " + uin + ", Province Name: " + provinceName);
        });
    }

    private static Province findProvinceByCode(List<Province> provinceList, String code) {
        for (Province province : provinceList) {
            if (province.name().equalsIgnoreCase(code)) {
                return province;
            }
        }
        return null;
    }
}
