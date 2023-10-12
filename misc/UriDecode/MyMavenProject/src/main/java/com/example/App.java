package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        String str = "Request%20Created";
        System.out.println(String.format("Decode: \"%s\" -> \"%s\"", str, Util.decodeUrlParameter(str)));
    }
}
