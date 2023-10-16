package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
    @Test
    public void testDecodeUrlParameter() {
        String encodedStr = "Request%20Created";
        String decodedStr = Util.decodeUrlParameter(encodedStr);
        assertEquals("Request Created", decodedStr);
    }
}
