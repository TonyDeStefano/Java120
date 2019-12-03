package uw.cp120.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Abstract class definition for a shape.
 * @author Tony DeStefano
 *
 */
public abstract class GeoShape {

    /**
     * The default origin
     */
    public static final GeoPoint DEFAULT_ORIGIN = new GeoPoint( 0, 0 );
    
    /**
     * The default color
     */
    public static final Color DEFAULT_COLOR = Color.BLUE;
    
    /**
     * The origin of the shape
     */
    private GeoPoint origin;
    
    /**
     * The color of the shape
     */
    private Color color;
    
    /**
     * Overloaded constructor
     * @param origin
     * @param color
     * @throws NullPointerException
     */
    public GeoShape( GeoPoint origin, Color color ) throws NullPointerException
    {
        if ( origin == null )
            throw new NullPointerException();
        
        this.origin = origin;
        this.color = color;
        
    }
    
    /**
     * Returns a formatted string.
     * @return String
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "origin=" );
        builder.append( origin.toString() );
        builder.append( ",color=" );
        builder.append( 
            color == null ? 
            "null" : 
            String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue() ) 
        );
        
        return builder.toString();
    }
    
    /**
     * Abstract class definition for drawing a shape
     * @param gtx
     */
    public abstract void draw( Graphics2D gtx );
    
    /**
     * Gets the origin
     * @return origin
     */
    public GeoPoint getOrigin()
    {
        return origin;
    }
    
    /**
     * Sets the origin
     * @param origin
     * @throws NullPointerException
     */
    public void setOrigin( GeoPoint origin ) throws NullPointerException
    {
        if ( origin == null )
        {
            throw new NullPointerException();
        }
        
        this.origin = origin;
    }
    
    /**
     * Sets the color
     * @param color
     */
    public void setColor( Color color )
    {
        this.color = color;
    }
    
    /**
     * Gets the color
     * @return color
     */
    public Color getColor()
    {
        return color;
    }
}
