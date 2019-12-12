package uw.cp120.assignments.geo_shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

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
        Arc2D oval = new Arc2D.Double(
            this.getOrigin().getXco(), 
            this.getOrigin().getYco(), 
            this.getWidth(), 
            this.getHeight(),
            0,
            360,
            Arc2D.OPEN);
            
        this.draw( oval, gtx );
    }
    
    /**
     * Asserts if two GeoOvals are equal
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
        else if ( other instanceof GeoOval == false )
        {
            b = false;
        }
        else if ( ! super.equals( other, epsilon ) )
        {
            b = false;
        }
        else if ( this.getColor() != other.getColor() )
        {
            b = false;
        }
        else if ( ! this.equals( ( ( GeoRectangle ) other).getWidth(), this.getWidth(), epsilon ) )
        {
            b = false;
        }
        else if ( ! this.equals( ( ( GeoRectangle ) other).getHeight(), this.getHeight(), epsilon ) )
        {
            b = false;
        }
            
        return b;
    }
    
    /**
     * @return the perimeter of an oval as a double
     */
    public double perimeter()
    {
        double a = Math.pow( this.getWidth() / 2, 2 );
        double b = Math.pow( this.getHeight() / 2, 2 );
        
        return ( 2 * Math.PI ) * Math.sqrt( ( a + b ) / 2 );
    }
    
    /**
     * @return the area of an oval as a double
     */
    public double area()
    {
        double a = this.getWidth() / 2;
        double b = this.getHeight() / 2;
        
        return a * b * Math.PI;
    }
}
