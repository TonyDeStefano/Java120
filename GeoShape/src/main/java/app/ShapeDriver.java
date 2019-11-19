package app;

import java.awt.Color;

import uw.cp120.assignments.geo_shape.GeoOval;
import uw.cp120.assignments.geo_shape.GeoPlane;
import uw.cp120.assignments.geo_shape.GeoPoint;
import uw.cp120.assignments.geo_shape.GeoRectangle;

/**
 * A simple program to exercise the geo_shape package.
 * 
 * @author jack
 */
public class ShapeDriver
{    
    /** The plane to draw on. */
    private GeoPlane    plane   = new GeoPlane();
    
    /**
     * Program entry point.
     *
     * @param args command line arguments; not used.
     */
    public static void main(String[] args)
    {
        new ShapeDriver().execute();
    }
    
    /**
     * Exercise the geo_shape package.
     */
    private void execute()
    {
        newOval( 1.1f, 2.2f, Color.RED );
        newRect( 3.3f, 4.4f, Color.GREEN );
        newOval( 5.5f, 6.6f, Color.BLUE );
        newRect( 7.7f, 8.8f, Color.MAGENTA );
        newOval( 9.9f, 10.01f, Color.CYAN );
        newRect( 11.02f, 12.03f, Color.PINK );
        newRect( 12.02f, 13.03f, Color.BLACK );
        newRect( 13.02f, 14.03f, Color.WHITE );
        newOval( 14.5f, 8.6f, Color.LIGHT_GRAY );
        newOval( 15.5f, 9.6f, Color.DARK_GRAY );
        plane.redraw();
    }
    
    /**
     * Create a new oval, and add it to the drawing plane.
     *
     * @param xco   the x-coordinate of the upper left hand corner of the oval
     * @param yco   the y-coordinate of the upper left hand corner of the oval
     * @param color the color of the oval
     */
    private void newOval( float xco, float yco, Color color )
    {
        GeoOval     oval    = new GeoOval();
        GeoPoint    origin  = new GeoPoint();
        origin.setXco( xco );
        origin.setYco( yco );
        oval.setColor( color );
        oval.setOrigin( origin );
        oval.setHeight( 5.5 );
        oval.setWidth( 6.6 );
        System.out.println( oval.getColor() );
        plane.addShape( oval );
    }
    
    /**
     * Create a new rectangle, and add it to the drawing plane.
     *
     * @param xco   
     *     the x-coordinate of the upper left hand corner of the oval
     * @param yco
     *     the y-coordinate of the upper left hand corner of the oval
     * @param color the color of the oval
     */
    private void newRect( float xco, float yco, Color color )
    {
        GeoRectangle    rect    = new GeoRectangle();
        GeoPoint        origin  = new GeoPoint();
        origin.setXco( xco );
        origin.setYco( yco );
        rect.setColor( color );
        rect.setOrigin( origin );
        rect.setHeight( 5.5 );
        rect.setWidth( 6.6 );
        System.out.println( rect.getColor() );
        plane.addShape( rect );
    }
}