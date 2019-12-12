package uw.cp120.assignments.geo_shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 * GeoLine class
 * @author Tony DeStefano
 *
 */
public class GeoLine extends GeoShape {
    
    /**
     * End point
     */
    private GeoPoint end = new GeoPoint( 0, 0 );
    
    /**
     * Overloaded constructor
     * @param start
     * @param end
     * @throws NullPointerException
     */
    public GeoLine( GeoPoint start, GeoPoint end ) throws NullPointerException
    {
        this( start, DEFAULT_COLOR, end, DEFAULT_EDGE_WIDTH );
    }
    
    /**
     * Overloaded constructor
     * @param start
     * @param color
     * @param end
     * @throws NullPointerException
     */
    public GeoLine( GeoPoint start, Color color, GeoPoint end )
    {
        this( start, color, end, DEFAULT_EDGE_WIDTH );
    }
    
    /**
     * Overloaded constructor
     * @param start
     * @param color
     * @param end
     * @param width
     * @throws NullPointerException
     */
    public GeoLine( GeoPoint start, Color color, GeoPoint end, double width ) throws NullPointerException
    {
        super( start, color );
        
        if ( end == null )
            throw new NullPointerException();
        
        this.setEnd( end );
        this.setEdgeWidth( width );
    }
    
    /**
     * Draws a line if the width is greater than zero and the color is not null.
     */
    public void draw( Graphics2D gtx )
    {
        Line2D line = new Line2D.Double(
            this.getOrigin().getXco(),
            this.getOrigin().getYco(),
            this.getEnd().getXco(),
            this.getEnd().getYco()
        );
        
        this.draw( line, gtx );
    }
    
    /**
     * Returns the distance between the two points (aka the length of the line)
     * @return the length of the line
     */
    public double length()
    {
        return this.getStart().distance( this.getEnd() );
    }
    
    /**
     * Calculates the slope of the line
     * @return the slope of the line
     */
    public double slope()
    {
        double y = this.getEnd().getYco() - this.getStart().getYco();
        double x = this.getEnd().getXco() - this.getStart().getXco();
        return y/x;
    }
    
    /**
     * Returns a formatted string.
     * @return String
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( super.toString() );
        builder.append( "end=(" );
        builder.append( this.getEnd().toString() );
        builder.append( ")" );
        
        return builder.toString();
    }
    
    /**
     * Alias for getOrigin()
     * @return the origin point
     */
    public GeoPoint getStart()
    {
        return getOrigin();
    }
    
    /**
     * Alias for setOrigin()
     * @param start
     * @throws NullPointerException
     */
    public void setStart( GeoPoint start ) throws NullPointerException
    {
        this.setOrigin( start );
    }
    
    /**
     * Set End
     * @param end
     * @throws NullPointerException
     */
    public void setEnd( GeoPoint end ) throws NullPointerException
    {
        if ( end == null )
            throw new NullPointerException();
        
        this.end = end;
    }
    
    /**
     * Get End
     * @return a geopoint
     */
    public GeoPoint getEnd()
    {
        return end;
    }
    
    /**
     * Sets the edge color
     * @param color
     */
    public void setColor( Color color )
    {
        this.setEdgeColor( color );
    }
    
    /**
     * Gets the edge color
     * @return the edge color
     */
    public Color getColor()
    {
        return this.getEdgeColor();
    }
    
    /**
     * Determines of if the object passed in is equal to this line
     * @return true or false
     */
    public boolean equals( GeoShape shape, double epsilon )
    {
        boolean retVal = true;
        
        if ( shape == null )
        {
            retVal = false;
        }
        else if ( shape instanceof GeoLine == false )
        {
            retVal = false;
        } 
        else if ( ! super.equals( shape, epsilon ) )
        {
            retVal = false;
        }
        else if ( this.getColor() != shape.getColor() )
        {
            retVal = false;
        }
        else if ( ! this.equals( ( ( GeoLine ) shape).getEdgeWidth(), this.getEdgeWidth(), epsilon ) )
        {
            retVal = false;
        }
        
        return retVal;
    }
}
