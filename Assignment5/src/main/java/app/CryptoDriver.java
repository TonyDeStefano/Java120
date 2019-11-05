package app;

import uw.cp120.assignments.assignment5.Crypto;

public class CryptoDriver
{
    private static String[] allTests    =
    {
        "Alligator",
        "Squirrel",
        "Wallaby",
        "Parrot",
        "Moose",
        "Lynx",
        "cat",
        "42",
        "X"
    };

    public static void main(String[] args)
    {
        for ( String str : allTests )
        {
            String  encrStr = Crypto.encrypt( str );
            String  decrStr = Crypto.decrypt( encrStr );
            System.out.println(  "String to encrypt: " + str );
            System.out.println(  "Decrypted string:  " + decrStr );
            printUnicode( encrStr );
            System.out.println();
        }

    }

    private static void printUnicode( String str )
    {
        char[]  characters  = str.toCharArray();
        System.out.print( "    " );
        for ( char ccc : characters )
            System.out.printf( "%3d ", (int)ccc );
        System.out.println();
    }
}