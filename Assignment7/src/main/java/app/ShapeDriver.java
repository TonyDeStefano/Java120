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
        newOval( 1.1, 2.2, Color.RED, 10.3, 20.7 );
        newRect( 3.3, 4.4, Color.GREEN, 10.3, 20.7 );
        newOval( 5.5, 6.6, Color.BLUE, 15.2, 31.6 );
        newRect( 5.5, 6.6, Color.BLUE, 15.2, 31.6 );
        newOval( 9.9, 10.01, Color.CYAN, 91.4, 50.2 );
        newRect( 9.9, 10.01, Color.CYAN, 91.4, 50.2 );
        newRect( 12.02, 13.03, Color.BLACK, 23.6, 17.9 );
        newRect( 13.02, 14.03, Color.WHITE, 4.5, 6.2 );
        newOval( 12.02, 13.03, Color.BLACK, 23.6, 17.9 );
        newOval( 13.02, 14.03, Color.WHITE, 4.5, 6.2 );
        plane.redraw();
        
        GeoPoint    point1  = new GeoPoint( 5, 6 );
        GeoPoint    point2  = new GeoPoint( 5, 6 );
        GeoPoint    point3  = new GeoPoint( 1, 5.11119 );
        GeoPoint    point4  = new GeoPoint( 1, 5.1112345);
        
        geoPointEqualsCheck( point1, point1 );
        geoPointEqualsCheck( point1, point2 );
        geoPointEqualsCheck( point2, point1 );
        geoPointEqualsCheck( point1, point3 );
        geoPointEqualsCheck( point1, null );
        geoPointEqualsCheck( point1, point3 );
        geoPointEqualsCheck( point3, point4 );
    }
    
    private void geoPointEqualsCheck( GeoPoint pointA, GeoPoint pointB )
    {
        final double    epsilon = .0001;
        System.out.print( "GeoPoint equality check:" );
        System.out.print(  pointA + "/" + pointB + ": " );
        System.out.println( pointA.equals( pointB, epsilon ) );
    }
    
    /**
     * Create a new oval, and add it to the drawing plane.
     *
     * @param xco   the x-coordinate of the upper left hand corner of the oval
     * @param yco   the y-coordinate of the upper left hand corner of the oval
     * @param color the color of the oval
     */
    private void 
    newOval( double xco, double yco, Color color, double wid, double hei )
    {
        GeoPoint    origin  = new GeoPoint( xco, yco );
        GeoOval     oval    = new GeoOval( origin, color, wid, hei );
        plane.addShape( oval );
        System.out.println( "GeoOval: " + oval );
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
    private void 
    newRect( double xco, double yco, Color color, double wid, double hei )
    {
        GeoPoint        origin  = new GeoPoint( xco, yco );
        GeoRectangle    rect    = new GeoRectangle( origin, color, wid, hei );
        plane.addShape( rect );
        System.out.println( "GeoRectangle: " + rect );
        System.out.printf(  "    area = %.04f\n", rect.area() );
        System.out.printf(  "    peri = %.04f\n", rect.perimeter() );
    }
}
