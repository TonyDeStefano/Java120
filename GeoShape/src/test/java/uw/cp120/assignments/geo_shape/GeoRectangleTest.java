package uw.cp120.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeoRectangleTest {

    @Test
    void test() {
        
        GeoRectangle rect = new GeoRectangle();
        assertTrue( rect instanceof GeoRectangle );
        
        rect.draw( null );
    }

}
