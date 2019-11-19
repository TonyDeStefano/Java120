package uw.cp120.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeoOvalTest {

    @Test
    void test() {
       
        GeoOval oval = new GeoOval();
        assertTrue( oval instanceof GeoOval );
        
        oval.draw( null );
    }

}
