package com.sutek.enumexample.province.bo;

import java.io.Serializable;

public class UIN implements Serializable {
    private static final long serialVersionUID = 1L;

    private String speciality;
    private String province;
    private String uin;

    public UIN(String speciality, String province, String uin) {
        this.speciality = speciality;
        this.province = province;
        this.uin = uin;
    }

    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getUin() {
        return uin;
    }
    public void setUin(String uin) {
        this.uin = uin;
    }

    @Override
    public String toString() {
        return "UIN [speciality=" + speciality + ", province=" + province + ", uin=" + uin + "]";
    }
}
