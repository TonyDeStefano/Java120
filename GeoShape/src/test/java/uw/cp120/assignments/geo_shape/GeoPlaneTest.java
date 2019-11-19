package uw.cp120.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeoPlaneTest {

    @Test
    void test() {
       
        GeoPlane plane = new GeoPlane();
        GeoRectangle rect = new GeoRectangle();
        GeoOval oval = new GeoOval();
        
        plane.addShape( rect );
        plane.addShape( oval );
        
        boolean wasFound = plane.removeShape( oval );
        assertTrue( wasFound );
        
        plane.redraw();
    }

}
