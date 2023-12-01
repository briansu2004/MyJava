package com.sutek.enumexample.province;

import java.util.ArrayList;
import java.util.List;
import com.sutek.enumexample.province.bo.Provider;
import com.sutek.enumexample.province.bo.UIN;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        getUIN();

        System.out.println("Nice!");
    }


    public static void getUIN() {
        // mock data
        UIN u1 = new UIN("AB", "ON", "123");
        UIN u2 = new UIN("GH", "QC", "5436");
        UIN u3 = new UIN("KL", "AB", "33455");

        List<UIN> mockUINs = new ArrayList<>();
        mockUINs.add(u1);
        mockUINs.add(u2);
        mockUINs.add(u3);

        Provider provider = new Provider();
        provider.setUin(mockUINs);

        // business logic
        List<UIN> lstUIN = provider.getUin();

        // Using forEach with lambda expression to print each element
        // lstUIN.forEach(uin -> System.out.println(uin));
        lstUIN.forEach(uin -> {
            String provinceName = uin.getProvince();
            System.out.println("UIN: " + uin + ", Province Name: " + provinceName);
        });
    }
}
