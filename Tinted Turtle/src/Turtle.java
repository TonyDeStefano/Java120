import java.awt.Color;

/**'
 * 
 * @author Tony DeStefano
 *
 */
public class Turtle {

    private double degrees;
    private double pixels;
    private Color color;
    
    /**
     * 
     * @param degrees
     * @return
     */
    public Turtle setDegrees( double degrees )
    {
        this.degrees = degrees;
        
        return this;
    }
    
    /**
     * 
     * @param pixels
     * @return
     */
    public Turtle setPixels( double pixels )
    {
        this.pixels = pixels;
        
        return this;
    }
    
    /**
     * 
     * @param color
     * @return
     */
    public Turtle setColor( Color color )
    {
        this.color = color;
        
        return this;
    }
}
