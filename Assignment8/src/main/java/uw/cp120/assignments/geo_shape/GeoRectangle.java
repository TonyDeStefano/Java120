package uw.cp120.assignments.geo_shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

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
     * Overloaded constructor with width and height
     * @param width
     * @param height
     */
    public GeoRectangle( double width, double height )
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
    public GeoRectangle( GeoPoint origin, double width, double height ) throws NullPointerException
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
    public GeoRectangle( GeoPoint origin, Color color, double width, double height ) throws NullPointerException
    {   
        super( origin, color );
       
        this.width = width;
        this.height = height;
    }
    
    /**
     * Returns a formatted string.
     * @return String
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( super.toString() );
        builder.append( ",width=" );
        builder.append( String.format( "%.4f", width ) );
        builder.append( ",height=" );
        builder.append( String.format( "%.4f", height ) );
        
        return builder.toString();
    }
    
    /**
     * Draws the rectangle.
     */
    public void draw( Graphics2D gtx )
    {
        Rectangle2D rect = new Rectangle2D.Double(
            this.getOrigin().getXco(), 
            this.getOrigin().getYco(), 
            width, 
            height);
        
        if ( this.getColor() != null ) {
            gtx.setColor( this.getColor() );
            gtx.fill( rect );
        }
        
        if ( this.getEdgeColor() != null && this.getEdgeWidth() > 0 ) {
            BasicStroke stroke = new BasicStroke( (float) this.getEdgeWidth() );
            gtx.setStroke( stroke );
            gtx.setColor( this.getEdgeColor() );
        }
        
        gtx.draw( rect );
    }
    
    /**
     * Returns the area
     * @return a double
     */
    public double area()
    {
        return height * width;
    }
    
    /**
     * Returns the perimeter
     * @return a double
     */
    public double perimeter()
    {
        return ( height * 2 ) + ( width * 2 );
    }
    
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
     * Asserts if two GeoRectangles are equal
     * @param other
     * @param epsilon
     * @return true or false
     */
    public boolean equals( GeoShape other, double epsilon )
    {
        boolean b = true;
        
        if ( other == null )
        {
            b = false;
        } 
        else if ( other instanceof GeoRectangle == false )
        {
            b = false;
        }
        else if ( !super.equals( other, epsilon ) )
        {
            b = false;
        }
        else if ( this.getColor() != other.getColor() )
        {
            b = false;
        }
        else if ( Math.abs( ( ( GeoRectangle ) other).getWidth() - width ) >= epsilon )
        {
            b = false;
        }
        else if ( Math.abs( ( ( GeoRectangle ) other).getHeight() - height ) >= epsilon )
        {
            b = false;
        }
            
        return b;
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
}
