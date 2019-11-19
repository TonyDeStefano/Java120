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
     * The origin of the shape
     */
    private GeoPoint origin;
    
    /**
     * The color of the shape
     */
    private Color color;
    
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
