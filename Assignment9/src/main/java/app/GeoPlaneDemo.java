package app;

import java.awt.Color;

import uw.cp120.assignments.geo_shape.GeoPlane;
import uw.cp120.assignments.geo_shape.GeoPoint;
import uw.cp120.assignments.geo_shape.GeoRectangle;

public class GeoPlaneDemo
{
    public static void main(String[] args)
    {
        // Create and show the plane
        GeoPlane        plane   = new GeoPlane();
        plane.show();

        // Create a GeoShape and add it to the plane
        GeoPoint        origin  = new GeoPoint( 50, 50 );
        GeoRectangle    rect    =
            new GeoRectangle( origin, Color.BLUE, 100, 100 );
        
        // If you want an edge, add an edge color and edge width
        rect.setEdgeColor( Color.GREEN );
        rect.setEdgeWidth( 5 );
        
        // Add the shape to the plane
        plane.addShape( rect );
        
        // After adding a shape to the plane, the shape
        // not appear until the plane is redraw.
        plane.redraw();
        
        // Add another shape
        origin = new GeoPoint( 200, 200 );
        rect = new GeoRectangle( origin, Color.YELLOW, 200, 200 );
        plane.addShape( rect );
        
        // Don't forget to redraw
        plane.redraw();
        
        // Note: when adding multiple shapes at a time, normally
        // you would create and add all the shapes, and THEN
        // redraw only once.
    }

}