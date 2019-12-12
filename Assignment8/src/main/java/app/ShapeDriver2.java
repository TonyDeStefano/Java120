package app;

import uw.cp120.assignments.geo_shape.GeoLine;
import uw.cp120.assignments.geo_shape.GeoPoint;

public class ShapeDriver2
{
    private final Exerciser[]    lines   =
    {
        // 3-4-5 right triangle
        new Exerciser( new GeoPoint( 1, 2 ), new GeoPoint( 4, 6 ) ),
        
        // 5-12-13 right triangle
        new Exerciser( new GeoPoint( 1, 2 ), new GeoPoint( 6, 14 ) ),
        
        // Horizontal line
        new Exerciser( new GeoPoint( 20, 30 ), new GeoPoint( 40, 30 ) ),
        
        // Vertical line
        new Exerciser( new GeoPoint( .7, .5 ), new GeoPoint( .7, 3.6 )),
        
        // 45 degrees
        new Exerciser( new GeoPoint( 1, 2 ), new GeoPoint( 6, 7 ) ),
        
        // -45 degrees
        new Exerciser( new GeoPoint( 0, 0 ), new GeoPoint( 10, -10 ) ),
        
        // boundary case
        new Exerciser( new GeoPoint( 0, 0 ), new GeoPoint( 0, 0 ) ),
    };
    
    public static void main(String[] args)
    {
        ShapeDriver2    driver  = new ShapeDriver2();
        driver.execute();
    }
    
    private void execute()
    {
        for ( Exerciser line : lines )
            line.execute();
    }
    
    private class Exerciser
    {
        private GeoPoint    aPoint;
        private GeoPoint    bPoint;
        
        public Exerciser( GeoPoint aPoint, GeoPoint bPoint )
        {
            this.aPoint = aPoint;
            this.bPoint = bPoint;
        }
        
        public void execute()
        {
            final String    format  = "    %-8s: %.4f%n";
            
            GeoLine line        = new GeoLine( aPoint, bPoint );
            double  distance    = aPoint.distance( bPoint );
            double  length      = line.length();
            double  slope       = line.slope();
            
            System.out.printf( "%s :: %s%n", aPoint, bPoint );
            System.out.printf( format, "distance", distance );
            System.out.printf( format, "length", length );
            System.out.printf( format, "slope", slope );
        }
    }
}
