package uw.cp120.assignments.assignment4;

import javax.swing.JOptionPane;

public class Utils {

    /**
     * Prompts a user for a number between min and max.
     * @param min
     * @param max
     * @return the integer that the user entered, if valid
     * @throws OpCanceledException
     */
    public static int askInt( int min, int max ) throws OpCanceledException {
        
        // What the user entered:
        String resp;
        
        // Holds the converted value:
        int val = 0;
        
        // Keeps track of input validity between loops:
        Boolean valid = true;
        
        // If min is greater than max, then flip them:
        if ( min > max ) {
            int temp = min;
            min = max;
            max = temp;
        }
        
        while( true ) {
            
            // Get response from user:
            resp = JOptionPane.showInputDialog( "Enter an integer between " + min + " and " + max );
           
            // If the user presses "cancel" then throw an exception:
            if (resp == null) {
                
                throw new OpCanceledException();
            
            } else {
                
                // Check to see if the response is a valid integer:
                try {
                    
                    val = Integer.parseInt(resp);
                    
                    // Check to see if the integer is between the min and max:
                    if (val < min || val > max) {
                        valid = false;
                    } else {
                        valid = true;
                    }
                    
                } catch (NumberFormatException exc) {
                    valid = false;
                }
                
                // If it's not valid, then tell the user that it is not valid. 
                // Otherwise break out of the loop.
                if (!valid) {
                    JOptionPane.showMessageDialog( null, "\"" + resp + "\" is not valid");
                } else {
                    break;
                }
            }
        }
        
        return val;
    }
}
