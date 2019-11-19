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
    }

}
