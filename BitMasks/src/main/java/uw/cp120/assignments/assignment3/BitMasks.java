package uw.cp120.assignments.assignment3;

/**
 * A class to decode a register and return the values of its sub-parts.
 * @author Tony DeStefano
 *
 */
public class BitMasks {
    
    // Constants to hold each mask:
    final static int CONTROL_MASK    =   0b1111000000000000;
    final static int START_MASK      =   0b0000100000000000;
    final static int COUNT_MASK      =   0b0000011000000000;
    final static int DATA_MASK       =   0b0000000111100000;
    final static int SECURITY_MASK   =   0b0000000000011000;
    final static int ORIGIN_MASK     =   0b0000000000000111;
    
    /**
     * Method used to decode a 16 bit register
     * 
     * @param reg a 16 bit binary register
     * @return a string containing the values of the register's sub-parts
     */
    public static String decode( int reg )
    {
        // Initialize the string builder object:
        StringBuilder builder = new StringBuilder();
        
        builder.append( "origin=" + getValue( reg, ORIGIN_MASK ) );
        builder.append( ",security=" + getValue( reg, SECURITY_MASK ) );
        builder.append( ",data=" + getValue( reg, DATA_MASK ) );
        builder.append( ",count=" + getValue( reg, COUNT_MASK ) );
        builder.append( ",start=" + getValue( reg, START_MASK ) );
        builder.append( ",control=" + getValue( reg, CONTROL_MASK ) );
        
        // Return the string:
        return builder.toString();
    }
    
    /**
     * Method to get the sub-value of the register.
     * 
     * @param reg 16 bit binary register
     * @param mask 16 bit binary mask
     * @return int containing the value
     */
    private static int getValue( int reg, int mask ) 
    {
        // Mask the register:
        int masked = reg & mask;
        
        // Return the value after the shift:
        return masked >> getShiftPosition( mask );
    }
    
    /**
     * Method to dynamically determine the shift position of the mask
     * because human error is the reason we have bugs. :)
     * 
     * @param mask a 16 bit mask
     * @return int the shift position
     */
    private static int getShiftPosition( int mask )
    {
        // Convert the int to a binary string:
        String str = Integer.toBinaryString( mask );
        
        // Convert the string to an array of chars:
        char[] chars = str.toCharArray();
        
        // Set the default shift to zero:
        int shift = 0;
        
        // Loop backwards through the array to find the first one:
        for ( int x = chars.length - 1; x >= 0; x-- )
        {
            // If a one is found, then break:
            if ( chars[x] == '1')
            {
                break;
            }
            
            // Otherwise, increase the shift value:
            shift++;
        }
        
        // Return the shift value:
        return shift;
    }
}
