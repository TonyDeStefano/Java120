package uw.cp120.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class definition for an oval.
 * @author Tony DeStefano
 *
 */
public class GeoOval extends GeoRectangle {
    
    /**
     * Overloaded constructor with width and height
     * @param width
     * @param height
     */
    public GeoOval( double width, double height )
    {
        this( DEFAULT_ORIGIN, DEFAULT_COLOR, width, height );
    }
    
    /**
     * Overloaded constructor with origin, width and height
     * @param origin
     * @param width
     * @param height
     * @throws NullPointerException
     */
    public GeoOval( GeoPoint origin, double width, double height ) throws NullPointerException
    {   
        this( origin, DEFAULT_COLOR, width, height );
    }
    
    /**
     * Overloaded constructor with origin, color, width and height
     * @param origin
     * @param color
     * @param width
     * @param height
     * @throws NullPointerException
     */
    public GeoOval( GeoPoint origin, Color color, double width, double height ) throws NullPointerException
    {
        super( origin, width, height );
        this.setColor( color );
    }
    
    /**
     * Draws the oval
     */
    public void draw( Graphics2D gtx )
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "Drawing oval: " );
        builder.append( this.toString() );
        
        System.out.println( builder.toString() );
    }
}
