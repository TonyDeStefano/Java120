package app;

import uw.cp120.assignments.assignment4.OpCanceledException;
import uw.cp120.assignments.assignment4.Utils;

/**
 * Driver class for this assignment.
 * @author Tony DeStefano
 *
 */
public class Main {

    /**
     * Starting point for application.
     * @param args
     */
    public static void main(String[] args) {
        
        int response;
        
        try {
            response = Utils.askInt( 5, 10 );
            System.out.println( "User entered " + response );
        } catch (OpCanceledException e) {
            System.out.println( "User canceled" );
        }

    }
}
