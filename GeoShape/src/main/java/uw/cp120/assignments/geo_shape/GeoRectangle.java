package uw.cp120.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class definition for a rectangle.
 * @author Tony DeStefano
 *
 */
public class GeoRectangle extends GeoShape {

    /**
     * The width of the shape
     */
    private double width = 0;
    
    /**
     * The height of the shape
     */
    private double height = 0;
    
    /**
     * Sets the width
     * @param width
     */
    public void setWidth( double width )
    {
        this.width = width;
    }
    
    /**
     * Gets the width
     * @return width
     */
    public double getWidth()
    {
        return width;
    }
    
    /**
     * Sets the height
     * @param height
     */
    public void setHeight( double height )
    {
        this.height = height;
    }
    
    /**
     * Gets the height
     * @return height
     */
    public double getHeight()
    {
        return height;
    }
    
    /**
     * Draws the rectangle
     */
    public void draw( Graphics2D gtx )
    {
        System.out.println( "Drawing rectangle" );
    }
}
