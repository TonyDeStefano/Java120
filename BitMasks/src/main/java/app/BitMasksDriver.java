package app;

import uw.cp120.assignments.assignment3.BitMasks;

public class BitMasksDriver
{
    /**
     * Main entry point. Strictly used for testing.
     * 
     * @param args Command line arguments; not used.
     */
    public static void main( String[] args )
    {
        // 0110 1 01 1000 11 001
        decode( 0b0110101100011001 );
        
        // 1000 0 10 0001 00 100
        decode( 0b1000010000100100 );
        
        // 1001 1 11 1110 11 011
        decode( 0b1001111111011011 );
    }
    
    private static void decode( int reg )
    {
        String  regStr  = Integer.toBinaryString( reg );
        String  decStr  = BitMasks.decode( reg );
        System.out.println( regStr );
        System.out.println( decStr );
        System.out.println();
    }
}