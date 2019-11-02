package uw.cp120.assignments.assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit tests.
 * @author Tony DeStefano
 *
 */
class OpCanceledExceptionTest {

    /**
     * Test to see if we can instantiate the exception and that it is the correct class:
     */
    @Test
    void testOpCanceledException() {
        
        OpCanceledException e = new OpCanceledException();
        assertTrue( e instanceof OpCanceledException );
    }

}
