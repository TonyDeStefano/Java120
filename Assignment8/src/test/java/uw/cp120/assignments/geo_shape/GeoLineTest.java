package uw.cp120.assignments.geo_shape;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GeoLineTest {

    @Test
    void test() {
        
        GeoLine line1 = new GeoLine( new GeoPoint( 0, 0 ), new GeoPoint( 3, 4 ) );
        GeoLine line2 = new GeoLine( new GeoPoint( 0, 0 ), Color.CYAN, new GeoPoint( 7, 7 ) );
        GeoLine line3 = new GeoLine( new GeoPoint( 0, 0 ), Color.RED, new GeoPoint( 7, 7 ), 2 );
        
        line1.setEdgeWidth( 3 );
        line1.setColor( Color.YELLOW );
        line2.setEdgeWidth( 1 );
        
        //assertEquals( line1.length(), 5, .00001 );
        //assertEquals( line1.slope(), line3.slope(), .00001 );
        
        try {
            GeoLine line4 = new GeoLine( null, null );
            fail("Should throw exception");
        } catch ( NullPointerException e ) {
            ;
        }
        
        try {
            GeoLine line5 = new GeoLine( new GeoPoint( 0, 0 ), null, null, 1 );
            fail("Should throw exception");
        } catch ( NullPointerException e ) {
            ;
        }
        
        try {
            line1.setStart( null );
            fail("Should throw exception");
        } catch ( NullPointerException e ) {
            ;
        }
        
        try {
            line1.setEnd( null );
            fail("Should throw exception");
        } catch ( NullPointerException e ) {
            ;
        }
        
        line1.length();
        line1.slope();
        line1.toString();
        line1.setStart( line1.getStart() );
        line1.setEnd( line1.getEnd() );
    }

}
