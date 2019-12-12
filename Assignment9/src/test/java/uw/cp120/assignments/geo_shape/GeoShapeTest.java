package uw.cp120.assignments.geo_shape;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class GeoShapeTest {

    @Test
    void test() {
        
        GeoRectangle rect = new GeoRectangle( 2, 5);
        GeoPoint point = new GeoPoint();
        point.setXco( 1 );
        point.setYco( 2 );
        
        rect.setColor( Color.BLUE );
        rect.setHeight( 2 );
        rect.setWidth( 5 );
        rect.setOrigin( point );
        
        assertTrue( rect.getColor() == Color.BLUE );
        assertTrue( rect.getHeight() == 2 );
        assertTrue( rect.getWidth() == 5 );
        assertTrue( rect.getOrigin() == point );
        
        try
        {
            rect.setOrigin( null );
        }
        catch( NullPointerException e )
        {
            assertTrue( e instanceof NullPointerException );
        }
        
        try
        {
            GeoRectangle rect2 = new GeoRectangle( null, Color.BLACK, 2, 2 );
        }
        catch( NullPointerException e )
        {
            assertTrue( e instanceof NullPointerException );
        }
    }

}
