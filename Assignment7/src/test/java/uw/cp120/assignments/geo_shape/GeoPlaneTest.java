package uw.cp120.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeoPlaneTest {

    @Test
    void test() {
       
        GeoPlane plane = new GeoPlane();
        GeoRectangle rect = new GeoRectangle( 4, 5 );
        GeoOval oval = new GeoOval( 7, 8 );
        
        plane.addShape( rect );
        plane.addShape( oval );
        
        boolean wasFound = plane.removeShape( oval );
        assertTrue( wasFound );
        
        plane.redraw();
    }

}
