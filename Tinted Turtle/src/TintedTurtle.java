import java.awt.Color;

/**
 * 
 * @author Tony DeStefano
 *
 */
public class TintedTurtle extends Turtle {

    /**
     * 
     * @param color
     * @param degrees
     * @param pixels
     */
    public TintedTurtle( Color color, double degrees, double pixels )
    {
        this
            .setColor( color )
            .setDegrees( degrees )
            .setPixels( pixels );
    }
}
