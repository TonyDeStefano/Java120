package uw.cp120.assignments.assignment1;

/**
 * CP120 Assignment 1
 * 
 * 1. Create a Maven project
 * 2. Import the project into your IDE
 * 3. Add this file to your project
 * 4. Complete the methods rectPerimeter, rectArea, circPerimeter and circArea.
 * 5. For an extra 10 points, complete rectPerimeterDiag and rectAreaDiag.
 */
public class Figures
{
    /**
     * Entry point.
     *
     * @param args command-line arguments, not used.
     */
    public static void main(String[] args)
    {
        /**
         * Rectangle coordinates:
         */
        double[][]  rects   = { { 5, 10 }, { 15, 6 }, { 7, 19 }, { 9, 9 }, { 14, 2 } };
        String      fmt     = "\tside1: %10.5f, side2: %10.5f, "
                              + "peri = %10.5f, area = %10.5f%n";
        System.out.println( "Rectangles" );
        for ( double[] rect : rects )
        {
            double  side1   = rect[0];
            double  side2   = rect[1];
            double  peri    = rectPerimeter( side1, side2 );
            double  area    = rectArea( side1, side2 );
            System.out.printf( fmt, side1, side2, peri, area );
        }
                
        /**
         * Circle coordinates:
         */
        double[]    circs   = { 5, 10, 15, 20, 21 };
        fmt = "\tradius: %10.5f, peri = %10.5f, area = %10.5f%n";
        System.out.println( "Circles" );
        for ( double radius : circs )
        {
           double   peri    = circPerimeter( radius );
           double   area    = circArea( radius );
           System.out.printf( fmt, radius, peri, area );
        }
        
        /**
         * Bonus coordinates:
         */
        double[][]  slopesAndDiags   = { { .5, 10 }, { .25, 6 }, { .675, 19 }, { 1, 9 }, { .8, 2 } };
        fmt = "\tslope: %10.5f, diag: %10.5f, peri = %10.5f, area = %10.5f%n";
        System.out.println( "Bonus" );
        for ( double[] slopeAndDiag : slopesAndDiags )
        {
            double  slope   = slopeAndDiag[0];
            double  diag    = slopeAndDiag[1];
            double  peri    = rectPerimeterDiag( diag, slope );
            double  area    = rectAreaDiag( diag, slope );
            System.out.printf( fmt, slope, diag, peri, area );
        }
    }

    /**
     * Given two adjacent sides of a rectangle, compute the perimeter
     *
     * @param side1 the first side; must be greater than 0
     * @param side2 the adjacent side; must be greater than 0
     * @return the perimeter of the rectangle, or Double.NaN
     *         if either parameter is invalid
     */
    public static double rectPerimeter( double side1, double side2 )
    {
        if (side1 <= 0 || side2 <= 0) {
            return Double.NaN;
        }

        /**
         * The perimeter of a rectangle.
         */
        double  peri = (side1 +side2) * 2;
        return peri;
    }
    
    /**
     * Given two adjacent sides of a rectangle, computer the area
     *
     * @param side1 the first side; must be greater than 0
     * @param side2 the adjacent side; must be greater than 0
     * @return the area of the rectangle, or Double.NaN
     *         if either parameter is invalid
     */
    public static double rectArea( double side1, double side2 )
    {
        if (side1 <= 0 || side2 <= 0) {
            return Double.NaN;
        }

        /**
         * The area of a rectangle.
         */
        double area = side1 * side2;
        return area;
    }

    /**
     * Given the radius of a circle, calculate the perimeter of the circle.
     *
     * @param radius    the given radius
     * @return the perimeter of the circle
     *
     * @param radius the radius; must be greater than 0
     * @return the perimeter of the circle, or Double.NaN
     *         if the parameter is invalid
     */
    public static double circPerimeter( double radius )
    {
        if (radius <= 0) {
            return Double.NaN;
        }

        /**
         * The perimeter of a circle.
         */
        double  peri = 2 * Math.PI * radius; // replace the 0 with the perimeter.
        return peri;
    }
    
    /**
     * Given the radius of a circle, calculate the area of the circle.
     *
     * @param radius the radius of the circle; must be greater than 0
     * @return the area of the circle, or Double.NaN
     *         if the parameter is invalid
     */
    public static double circArea( double radius )
    {
        if (radius <= 0) {
            return Double.NaN;
        }

        /**
         * The area of a circle.
         */
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }
    
    ///////////////////////////////////////////////////////////////////////
    // Bonus: for an extra 10 points, complete the following methods.
    ///////////////////////////////////////////////////////////////////////
    
    /**
     * Returns the sides a and b given diagonal and slope.
     * 
     * I broke this out into its own function because I didn't want
     * to duplicate code in the below two methods.
     * 
     * @param diag the hypotenuse of the rectangle; must be greater than 0 
     * @param slope the slope of the hupotenuse; must be not equal to 0
     * @return an array containing sides a and b
     */
    private static double[] getSidesFromDiagAndSlope( double diag, double slope)
    {
        double[] sides = { 0.0, 0.0 };
        
        // https://math.stackexchange.com/questions/566029/in-a-right-triangle-given-slope-and-length-of-hypotenuse-find-length-of-legs
        // a^2 + b^2 = c^2
        double b = diag / Math.sqrt( ( slope * slope ) + 1 );
        double a = Math.sqrt( ( diag * diag ) / ( b * b ) );
        sides[0] = a;
        sides[1] = b;
        
        return sides;
    }
    
    /**
     * Given the length and slope of the diagonal of a rectangle,
     * compute the perimeter of the rectangle.
     *
     * @param diag the given length; must be greater than 0
     * @param slope the given slope; must be not equal to 0
     * @return the perimeter of the rectangle, or Double.NaN
     *         if either parameter is invalid
     */
    public static double rectPerimeterDiag( double diag, double slope )
    {
        if (diag <= 0 || slope == 0) {
            return Double.NaN;
        }
        
        /** An array containing the sides */
        double[] sides = getSidesFromDiagAndSlope( diag, slope );
        
        return rectPerimeter( sides[0], sides[1] );
    }
    
    /**
     * Given the length and slope of the diagonal of a rectangle,
     * compute the area of the rectangle.
     *
     * @param diag the given length
     * @param slope the given slope
     * @return the area of the rectangle
     */
    // Bonus: for an extra 10 points, complete the following methods.
    public static double rectAreaDiag( double diag, double slope )
    {
        if (diag <= 0 || slope == 0) {
            return Double.NaN;
        }

        /** An array containing the sides */
        double[] sides = getSidesFromDiagAndSlope( diag, slope );
        
        return rectArea( sides[0], sides[1] );
    }
}