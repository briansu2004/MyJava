package com.sutek.jdbcoraclepom;

import java.sql.*;

public class OpenJdkJdbcOracle {
    public static void main(String args[]) {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "sys as sysdba",
                    "admin");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from dual");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}