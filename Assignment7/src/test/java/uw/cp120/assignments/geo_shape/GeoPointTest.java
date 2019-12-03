package uw.cp120.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeoPointTest {

    @Test
    void test() {
        
        GeoPoint point = new GeoPoint();
        point.setXco( 1 );
        point.setYco( 10 );
        
        assertTrue( point.getXco() == 1 );
        assertTrue( point.getYco() == 10 );
        
        GeoPoint point2 = new GeoPoint( 2, 3);
        assertFalse( point.equals( point2, .00001 ) );
        
        GeoPoint point3 = new GeoPoint( 1, 10 );
        assertTrue( point.equals( point3, .00001 ) );
    }

}