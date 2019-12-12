package uw.cp120.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeoOvalTest {

    @Test
    void test() {
       
        GeoOval oval1 = new GeoOval( 6, 7 );
        GeoOval oval2 = new GeoOval( new GeoPoint(), 6, 7 );
        assertTrue( oval2 instanceof GeoOval );
        
        oval2.draw( null );
        
        try
        {
            GeoOval oval3 = new GeoOval( null, 6, 7 );
        } catch ( NullPointerException e )
        {
            assertTrue( e instanceof NullPointerException );
        }
    }

}
