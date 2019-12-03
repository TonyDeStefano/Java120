package uw.cp120.d_list;

/**
 * Implementation of a doubly-linked list. 
 * The list itself is implemented as a Node; the flink and blink of the list point to the head and tail of the list, respectively.
 * 
 * Definition:
 *
 *    Empty list
 *        A list is empty if its flink and blink point to itself.
 *
 * Note that methods such as getHead() do not return null for an empty list; instead they return the list itself. Likewise, the flink and blink of the tail and head nodes, respectively, are not null; they point to the list, itself.
 *
 * Sample usage:
 *
 * <pre>
 *     DNode node = list.getHead();
 *     while ( node != list )
 *     {
 *         System.out.println( node.getData() );
 *         node = node.getNext();
 *     }
 * </pre>    
 * 
 * @author Tony DeStefano
 *
 */
public class DList extends DNode {
    
    /**
     * Adds a new node to the head of the list.
     * @param node - The node to add.
     */
    public void addHead( DNode node ) throws IllegalArgumentException
    {
        this.addAfter( node );
    }
    
    /**
     * Adds a new node to the tail of the list.
     * @param node - The node to add.
     */
    public void addTail( DNode node ) throws IllegalArgumentException
    {
        this.addBefore( node );
    }
    
    /**
     * Calculates the number of nodes in the list.
     * @return The number of nodes in the list.
     */
    public int size()
    {
        int size = 0;
        DNode node = getNext();
        
        while ( node != this )
        {
            size++;
            node = node.getNext();
        }
        
        return size;
    }
    
    /**
     * Returns the head of the list (without removing it). If the list is empty, the list is returned.
     * 
     * Example:
     * 
     * <pre>
     *     DNode node = list.getHead();
     *     if ( node == list )
     *         log( "the list is empty" );
     *     else
     *         process( node );
     * </pre>
     * 
     * @return The head of the list (without removing it).
     */
    public DNode getHead()
    {
        return getNext();
    }
    
    /**
     * Returns the tail of the list (without removing it). If the list is empty, the list is returned.
     *
     * Example:
     *
     * <pre>
     *     DNode node = list.getTail();
     *     if ( node == list )
     *         log( "the list is empty" );
     *     else
     *         process( node );
     * </pre>         
     * 
     * @return The tail of the list (without removing it).
     */
    public DNode getTail()
    {
        return getPrevious();
    }
    
    /**
     * Removes and returns the head of the list. 
     * If the list is empty, the list is returned.
     *
     * Example:
     *
     * <pre>
     *     DNode node = list.removeHead();
     *     if ( node == list )
     *         log( "the list is empty" );
     *     else
     *         process( node );
     * 
     * @return The head of the list (after removing it from the list).
     */
    public DNode removeHead()
    {
        return getHead().remove();
    }
    
    /**
     * Removes and returns the tail of the list. 
     * If the list is empty, the list is returned.
     * 
     * Example:
     *
     * <pre>
     *     DNode node = list.removeTail();
     *     if ( node == list )
     *         log( "the list is empty" );
     *     else
     *         process( node );
     * 
     * @return The tail of the list (after removing it from the list).
     */
    public DNode removeTail()
    {
        return getTail().remove();
    }
    
    /**
     * Removes all items from the list, leaving the list empty.
     */
    public void removeAll()
    {
        while ( size() > 0 )
        {
            getNext().remove();
        }
    }
    
    /**
     * Indicates whether or not the list is empty.
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return ( size() == 0 );
    }
}
