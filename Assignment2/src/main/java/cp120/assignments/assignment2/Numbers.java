package cp120.assignments.assignment2;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * This utility class implements some common class methods that perform arithmetic calculations.
 * @author Tony DeStefano
 *
 */
public class Numbers {

    /**
     * This method will return true if a given number is prime and false if num is not prime. 
     * 1 must be treated as non-prime.
     * 
     * @param num the number to test
     * @return boolean if the number is prime or not
     */
    public static boolean isPrime( int num )
    {
        /**
         * boolean return value
         */
        boolean boolIsPrime = true;
        
        /**
         * used for the for loop
         */
        int i; 
        
        /**
         * used to stop the for loop
         */
        int m = num/2;  
        
        if ( num != 0 && num != 1 )
        {   
            for( i=2; i <= m; i++ )
            {      
                if( num % i == 0)
                {       
                    boolIsPrime = false;
                    break;      
                }   
            }
        }
        else
        {
            boolIsPrime = false;
        }
        
        return boolIsPrime;
    }
    
    /**
     * This method will calculate the least common multiple of two given numbers. 
     * The numbers must be greater than 0.
     * 
     * @param param1 the first given number
     * @param param2 the second given number
     * @return int the least common multiple
     */
    public static int lcm( int param1, int param2 )
    {
        /**
         * the lowest common multiple to be returned
         */
        int lcm = 0;
        
        /**
         * the absolute value of param1
         */
        int absNumber1 = Math.abs( param1 );
        
        /**
         * the absolute value of param2
         */
        int absNumber2 = Math.abs( param2 );
        
        if ( param1 != 0 & param2 != 0) 
        {
            int absHigherNumber = Math.max( absNumber1, absNumber2 );
            int absLowerNumber = Math.min( absNumber1, absNumber2 );
            
            lcm = absHigherNumber;
            
            while (lcm % absLowerNumber != 0) 
            {
                lcm += absHigherNumber;
            }
        }
        
        return lcm;
    }
    
    /**
     * This method will calculate the greatest common factor of two given numbers. 
     * The numbers must be greater than 0.
     * 
     * @param param1 the first given number
     * @param param2 the second given number
     * @return int the greatest common factor
     */
    public static int gcf( int param1, int param2 )
    {
        /**
         * greatest common factor to be returned
         */
        int gcf = 0;
        
        for( int i = 1; i <= param1 && i <= param2; i++ )
        {
            if( param1 % i == 0 && param2 % i == 0 )
            {
                gcf = i;
            }
        }
        
        return gcf;
    }
    
    /**
     * This method will calculate the mean of the numbers in a given array. 
     * The array must contain at least 1 element.
     * 
     * @param arr an array of numbers
     * @return double the mean of given numbers
     */
    public static double mean( double[] arr )
    {
        /*
         * the mean to be returned
         */
        double mean = 0;
        
        /**
         * the sum of the items in the array
         */
        double sum = 0;
        
        if ( arr.length > 0 )
        {
            for ( double x : arr )
            {
                sum += x;
            }
            
            mean = sum / arr.length;
        }
        
        return mean;
    }
    
    /**
     * This method will calculate the median of the numbers in a given array. 
     * The array must contain at least 1 element.
     * 
     * @param arr and array of numbers
     * @return double the median
     */
    public static double median( double[] arr )
    {
        /**
         * the median to be returned
         */
        double median = 0;
        
        if ( arr.length > 0 )
        {
        
            /**
             * A copy of the array to sort
             */
            double[] arrCopy = arr;
            Arrays.parallelSort( arrCopy );
            
            if ( arr.length % 2 == 0 )
            {
                median = ( arrCopy[ arr.length / 2 ] + arrCopy[ (arr.length / 2) - 1 ] ) / 2;
            }
            else
            {
                median = arrCopy[ ( arr.length - 1 ) / 2 ];
            }
        }
        
        return median;
    }
    
    /**
     * This method will calculate the factorial of the given number. 
     * The number must be greater than or equal to 0.
     * 
     * @param num the given number
     * @return long the factorial of num
     */
    public static long factorial( long num )
    {
        /**
         * The factorial
         */
        long factorial = 0;
        
        if ( num == 0 )
        {
            factorial = 1;
        }
        else if ( num > 0 && num <= 20)
        {
            factorial = 1;
            
            for ( long i = 1; i <= num; i++ )
            {
                factorial = factorial * i;
            }
        }
        
        return factorial;
    }
    
    /**
     * This method will calculate the factorial of the given number. 
     * The number must be greater than or equal to 0.
     * 
     * @param num the given number
     * @return BigInteger the factorial of num
     */
    public static BigInteger factorial( BigInteger num )
    {
        /**
         * Start at one
         */
        BigInteger factorial = BigInteger.ONE; 
        
        for ( int i = num.intValue(); i > 0; i-- ) 
        { 
            factorial = factorial.multiply( BigInteger.valueOf( i ) ); 
        } 
        
        return factorial;

    }
}
