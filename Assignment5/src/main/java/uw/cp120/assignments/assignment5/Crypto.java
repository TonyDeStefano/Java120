package uw.cp120.assignments.assignment5;

/**
 * A class to encrypt and decrypt a string.
 * @author Tony DeStefano
 *
 */
public class Crypto {

    public static final char PADDING_CHAR = '\u0000';
    
    /**
     * Encrypts a string.
     * @param str string to be encrypted
     * @return encrypted string
     */
    public static String encrypt( String str ) 
    {
        // Pad string with null characters until it is evenly divisible by three:
        do
        {
            str = str + PADDING_CHAR;
        }
        while ( str.length() % 3 > 0 );
        
        // Rotate the last group of three to the front of the string:
        str = str.substring( str.length() - 3 ) + str.substring( 0, str.length() - 3 );
        
        StringBuilder builder = new StringBuilder();
        int counter = 0;
        
        // Loop through each character and increment based on position:
        for( char ch : str.toCharArray() )
        {
            ch += counter++;
            builder.append( ch );
        }
        
        return builder.toString();
    }
    
    /**
     * Decrypts a string.
     * @param str string to be decrypted
     * @return decrypted string
     */
    public static String decrypt( String str ) 
    {
        StringBuilder builder = new StringBuilder();
        int counter = 0;
        
        // Loop through each character and decrement based on position:
        for( char ch : str.toCharArray() )
        {
            ch -= counter++;
            builder.append( ch );
        }
        
        String newString = builder.toString();
        
        // Rotate the first group of three to the end of the string:
        newString =  newString.substring( 3 ) + newString.substring( 0, 3 );
        
        // Get rid of the padding characters at the end:
        builder.setLength( 0 );
        for( char ch : newString.toCharArray() )
        {
            if ( ch != PADDING_CHAR )
            {
                builder.append( ch );
            }
        }
        
        return builder.toString();
    }
}
