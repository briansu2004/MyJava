package com.sutek.enumexample.province.bo;

import java.io.Serializable;
import java.util.List;


/*
 * In Java, the Cloneable interface is a marker interface that indicates that the objects of the
 * class implementing it can be cloned. It doesn't declare any methods; instead, it serves as a
 * signal to the object's clone method that it is legal for that method to make a field-for-field
 * copy of instances of that class.
 */
public class Provider implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private List<UIN> uin;

    public List<UIN> getUin() {
        return uin;
    }

    public void setUin(List<UIN> uin) {
        this.uin = uin;
    }
}
