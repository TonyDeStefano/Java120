package uw.cp120.assignments.assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit tests.
 * @author Tony DeStefano
 *
 */
class UtilsTest {

    /**
     * Prompt tester to press the cancel button:
     */
    @Test
    void testCancel() {
        
        System.out.println("Press the cancel button.");
        
        try {
            Utils.askInt(5, 10);
        } catch ( OpCanceledException e ) {
            assertTrue(true);
        }
    }
    
    /**
     * Prompt tester to enter a string, then enter a valid number:
     */
    @Test
    void testStringInput() {
        
        int val = 0;
        
        System.out.println("Enter a string value. Then enter 7.");
        
        try {
            val = Utils.askInt(5, 10);
        } catch ( OpCanceledException e ) {
     
        }
        
        assertTrue(val == 7);
    }
    
    /**
     * Prompt tester to enter a low number, then enter a valid number:
     */
    @Test
    void testLowInput() {
        
        int val = 0;
        
        System.out.println("Enter an int below 5. Then enter 7.");
        
        try {
            val = Utils.askInt(5, 10);
        } catch ( OpCanceledException e ) {
          
        }
        
        assertTrue(val == 7);
    }
    
    /**
     * Prompt tester to enter a high number, then enter a valid number:
     */
    @Test
    void testHighInput() {
        
        int val = 0;
        
        System.out.println("Enter an int above 10. Then enter 7.");
        
        try {
            val = Utils.askInt(5, 10);
        } catch ( OpCanceledException e ) {
      
        }
        
        assertTrue(val == 7);
    }
    
    /**
     * Prompt tester to enter a valid number:
     */
    @Test
    void testValidInput() {
        
        int val = 0;
        
        System.out.println("Enter 7.");
        
        try {
            val = Utils.askInt(5, 10);
        } catch ( OpCanceledException e ) {
          
        }
        
        assertTrue(val == 7);
    }

}
