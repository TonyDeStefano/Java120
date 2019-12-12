package uw.cp120.assignments.geo_shape;

/**
 * Class definition for a point.
 * @author Tony DeStefano
 *
 */
public class GeoPoint {

    /**
     * The x-coordinate
     */
    private double xco;
    
    /**
     * The y-coordinate
     */
    private double yco;
    
    /**
     * Default constructor.
     */
    public GeoPoint()
    {
        this( 0, 0 );
    }
    
    /**
     * Constructor that sets xco and yco.
     * @param xco
     * @param yco
     */
    public GeoPoint( double xco, double yco )
    {
        this.xco = xco;
        this.yco = yco;
    }
    
    /**
     * Returns formatted string.
     * @return string
     */
    public String toString()
    {
        return String.format( "%.4f,%.4f", xco, yco );
    }
    
    /**
     * Asserts if two GeoPoints are equal
     * @param other a GeoPoint
     * @param epsilon the epsilon to use for comparison
     * @return true or false
     */
    public boolean equals( GeoPoint other, double epsilon )
    {
        return other != null && Math.abs( other.xco - xco ) < epsilon && Math.abs( other.yco - yco ) < epsilon;
    }
    
    /**
     * Returns the X-Coordinate
     * @return the xco
     */
    public double getXco() 
    {
        return xco;
    }
    
    /**
     * Sets the X-Coordinate
     * @param xco
     */
    public void setXco( double xco )
    {
        this.xco = xco;
    }
    
    /**
     * Returns the Y-Coordinate
     * @return yco
     */
    public double getYco()
    {
        return yco;
    }
    
    /**
     * Sets the Y-Coordinate
     * @param yco
     */
    public void setYco( double yco )
    {
        this.yco = yco;
    }
    
    /**
     * Calculates the distance between two points.
     * @param other
     * @return the distance
     */
    public double distance( GeoPoint other )
    {
        double x = Math.pow( ( this.xco - other.xco ), 2 );
        double y = Math.pow( ( this.yco - other.yco ), 2 );
        
        return Math.sqrt( x + y );
    }
}
