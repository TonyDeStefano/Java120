package uw.cp120.assignments.assignment5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CryptoTest {

    /**
     * Test to ensure that a zero length string works:
     */
    @Test
    void testZeroLength() 
    {
        String str = "";
        String encString = Crypto.encrypt(str);
        String decString = Crypto.decrypt(encString);
        assertTrue(decString.equals(str));
    }
    
    /**
     * Test to ensure that a string less than three characters works:
     */
    @Test
    void testLessThanThree() 
    {
        String str = "ab";
        String encString = Crypto.encrypt(str);
        String decString = Crypto.decrypt(encString);
        assertTrue(decString.equals(str));
    }

    /**
     * Test to ensure that a three character string works:
     */
    @Test
    void testThree() 
    {
        String str = "LOL";
        String encString = Crypto.encrypt(str);
        String decString = Crypto.decrypt(encString);
        assertTrue(decString.equals(str));
    }

    /**
     * Test to ensure that greater than three characters works:
     */
    @Test
    void testGreaterThanThree() 
    {
        String str = "That that is, is. That that isn't, isn't. That is it, isn't it? It is.";
        String encString = Crypto.encrypt(str);
        String decString = Crypto.decrypt(encString);
        assertTrue(decString.equals(str));
    }
}
