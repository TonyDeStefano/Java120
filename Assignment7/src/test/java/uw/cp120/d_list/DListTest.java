package uw.cp120.d_list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DListTest {

    @Test
    void test() {
        
        DList list = new DList();
        DNode node1 = new DNode();
        DNode node2 = new DNode();
        DNode node3 = new DNode();
        DNode node4 = new DNode();
        
        list.addHead( node1 );
        assertTrue( list.getHead() == node1 );
        
        list.addTail( node2 );
        assertTrue( list.getTail() == node2 );
        
        list.addHead( node3 );
        list.addTail( node4 );
        assertTrue( list.size() == 4 );
        
        list.removeHead();
        assertTrue( list.size() == 3 );
        
        list.removeTail();
        assertTrue( list.size() == 2 );
        
        assertFalse( list.isEmpty() );
        
        list.removeAll();
        assertTrue( list.isEmpty() );
    }

}
