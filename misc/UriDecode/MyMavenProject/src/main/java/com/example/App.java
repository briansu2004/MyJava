package com.example;

public class App 
{
    public static void main( String[] args )
    {
        String str = "Request%20Created";
        System.out.println(String.format("Decode: \"%s\" -> \"%s\"", str, Util.decodeUrlParameter(str)));
    }
}
