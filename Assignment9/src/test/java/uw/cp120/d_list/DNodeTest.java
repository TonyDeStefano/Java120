package uw.cp120.d_list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DNodeTest {

    @Test
    void test() {
       
        DNode node = new DNode();
        assertFalse( node.isEnqueued() );
    
        Object obj = new Object();
        node.setData( obj );
        assertTrue( node.getData() == obj );
        
        DNode nextNode = new DNode();
        node.addAfter( nextNode );
        assertTrue( node.getNext() == nextNode );
        
        DNode prevNode = new DNode();
        node.addBefore( prevNode );
        assertTrue( node.getPrevious() == prevNode );
        
        DNode newNode = new DNode();
        
        try
        {
            newNode.addBefore( node );
        } 
        catch( IllegalArgumentException e )
        {
            assertTrue( e instanceof IllegalArgumentException );
        }
        
        try
        {
            newNode.addAfter( node );
        } 
        catch( IllegalArgumentException e )
        {
            assertTrue( e instanceof IllegalArgumentException );
        }
        
    }

}
