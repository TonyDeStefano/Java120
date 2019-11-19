package uw.cp120.assignments.geo_shape;

import uw.cp120.d_list.DList;
import uw.cp120.d_list.DNode;

/**
 * Class definition for a plane.
 * @author Tony DeStefano
 *
 */
public class GeoPlane {

    /**
     * Initialize the shape list:
     */
    private DList shapes = new DList();
    
    /**
     * Adds a shape to the list
     * @param shape - the shape to add
     */
    public void addShape( GeoShape shape )
    {
        DNode node = new DNode( shape );
        shapes.addTail( node );
    }
    
    /**
     * Removes the first instance of passed in shape from the list.
     * @param shape
     * @return True if found, False if not found.
     */
    public boolean removeShape( GeoShape shape )
    {
        DNode node = shapes.getHead();
        boolean wasFound = false;
        
        while ( node != shapes )
        {
            if ( node.getData() == shape )
            {
                node.remove();
                wasFound = true;
                break;
            }
            
            node = node.getNext();
        }
        
        return wasFound;
    }
    
    /**
     * Redraw all shapes in list.
     */
    public void redraw()
    {
        DNode node = shapes.getHead();
        while ( node != shapes )
        {
            GeoShape shape = (GeoShape)node.getData();
            shape.draw( null );
            node = node.getNext();
        }
    }
}
