package uw.cp120.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class GeoOvalTest {

    @Test
    void test() {
       
        GeoOval oval1 = new GeoOval( 6, 7 );
        GeoOval oval2 = new GeoOval( new GeoPoint(), 6, 7 );
        assertTrue( oval2 instanceof GeoOval );
        
        try
        {
            GeoOval oval3 = new GeoOval( null, 6, 7 );
        } catch ( NullPointerException e )
        {
            assertTrue( e instanceof NullPointerException );
        }
        
        assertFalse( oval1.equals( null ) );
        assertFalse( oval1.equals( new GeoRectangle( 1, 2 ) ) );
        assertFalse( oval1.equals( oval2 ) );
        
        GeoOval oval4 = new GeoOval( 6, 7 );
        oval4.setColor( Color.BLACK );
        oval1.setColor( Color.BLUE );
        
        assertFalse( oval1.equals( oval4 ) );
        assertTrue( oval4.getColor() == Color.BLACK );
        oval4.setColor( Color.BLUE );
        assertFalse( oval1.equals( oval4 ) );
        
        oval1.area();
        oval1.perimeter();
    }

}
