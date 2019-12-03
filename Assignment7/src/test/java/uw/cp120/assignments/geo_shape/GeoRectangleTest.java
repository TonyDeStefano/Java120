package uw.cp120.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeoRectangleTest {

    @Test
    void test() {
        
        GeoRectangle rect = new GeoRectangle( 1, 2 );
        assertTrue( rect instanceof GeoRectangle );
        assertTrue( rect.area() == 2 );
        assertTrue( rect.perimeter() == 6 );
        
        rect.draw( null );
        
        GeoRectangle rect2 = new GeoRectangle( 2, 3 );
        assertFalse( rect.equals( rect2, .00001 ) );
        assertFalse( rect.equals( null, .00001 ) );
        assertFalse( rect.equals( new GeoOval( 1, 1 ), .00001 ) );
        
        GeoRectangle rect3 = new GeoRectangle( 1, 2 );
        assertTrue( rect.equals( rect3, .00001 ) );
    }
}
