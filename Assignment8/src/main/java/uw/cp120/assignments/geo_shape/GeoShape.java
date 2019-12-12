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
     * The default edge color
     */
    public static final Color DEFAULT_EDGE_COLOR = Color.BLUE;
    
    /**
     * The default edge width
     */
    public static final double DEFAULT_EDGE_WIDTH = 1;
    
    /**
     * The origin of the shape
     */
    private GeoPoint origin;
    
    /**
     * The color of the shape
     */
    private Color color;
    
    /**
     * The width of the edge
     */
    private double edgeWidth;
    
    /**
     * The color of the edge
     */
    private Color edgeColor;
    
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
        builder.append( "origin=(" );
        builder.append( origin.toString() );
        builder.append( "),color=" );
        builder.append( 
            color == null ? 
            "null" : 
            String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue() ) 
        );
        builder.append( ",edgeColor=" );
        builder.append( 
            edgeColor == null ? 
            "null" : 
            String.format("#%02x%02x%02x", edgeColor.getRed(), edgeColor.getGreen(), edgeColor.getBlue() ) 
        );
        builder.append( String.format( ",edgeWidth=%.4f", edgeColor ) );
        
        return builder.toString();
    }
    
    /**
     * Determines if two shapes are equal
     * @param shape
     * @param epsilon
     * @return true or false
     */
    public boolean equals( GeoShape shape, double epsilon )
    {
        boolean retVal = false;
        
        if ( shape != null ) {
            if ( shape.getOrigin().equals( origin, epsilon ) ) {
                if (shape.color == color && shape.edgeColor == edgeColor) {
                    if ( equals( shape.edgeWidth, edgeWidth, epsilon ) ) {
                        retVal = true;
                    }
                }
            }
        }
        
        return retVal;
    }
    
    /**
     * Determines if two doubles are equal
     * @param num1
     * @param num2
     * @param epsilon
     * @return true or false
     */
    public boolean equals( double num1, double num2, double epsilon )
    {
        return Math.abs( num1 - num2 ) < epsilon;
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
    
    /**
     * Gets the edge width
     * @return the width
     */
    public double getEdgeWidth()
    {
        return edgeWidth;
    }
    
    /**
     * Sets the edge width
     * @param width
     */
    public void setEdgeWidth( double width )
    {
        edgeWidth = width;
    }
    
    /**
     * Gets the edge color
     * @return the color
     */
    public Color getEdgeColor()
    {
        return edgeColor;
    }
    
    /**
     * Sets the edge color
     * @param color
     */
    public void setEdgeColor( Color color )
    {
        edgeColor = color;
    }
    
    /**
     * Sets the edge width and color
     * @param color
     * @param width
     */
    public void setEdge( Color color, double width )
    {
        edgeColor = color;
        edgeWidth = width;
    }
}
