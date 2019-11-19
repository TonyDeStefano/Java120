package uw.cp120.assignments.geo_shape;

/**
 * Class definition for a point.
 * @author Tony DeStefano
 *
 */
public class GeoPoint {

    // Initialize the X- and Y-Coordinates:
    private double xco = 0;
    private double yco = 0;
    
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
}
