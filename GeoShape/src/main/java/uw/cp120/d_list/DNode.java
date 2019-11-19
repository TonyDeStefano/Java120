package uw.cp120.d_list;

/**
 * <p>Encapsulation of a node in a doubly-linked list. The state of a node includes three references:</p>
 * <ul>
 *     <li>A reference to the user data stored in the node.</li>
 *     <li>A reference to the previous item in the list (if enqueued).</li>
 *     <li>A reference to the next item in the list (if enqueued).</li>
 * </ul>
 * <p>Definitions:</p>
 * <pre>
 *     Enqueued node
 *         A node is enqueued if its flink and blink point other items.
 *     Unenqueued node
 *         A node is unenqueued if its flink and blink point to itself.
 * </pre>
 * 
 * @author Tony DeStefano
 *
 */
public class DNode {

    /**
     * Backward link; reference to previous item
     */
    private DNode blink;
    
    /**
     * Forward link; reference to next item
     */
    private DNode flink;
    
    /**
     * Data stored in this item
     */
    private Object data;
    
    /**
     * Default constructor. The node is constructed in the unenqueued state.
     */
    public DNode()
    {
        this( null );
    }
    
    /**
     * Constructs a new node with the given data. The node is constructed in the unenqueued state.
     * @param data - The given data.
     */
    public DNode( Object data )
    {
        blink = this;
        flink = this;
        this.data = data;
    }
    
    /**
     * Adds a new node after this one. 
     * The new node must be in the unenqueued state; if it is not, an exception will be thrown.
     * @param node - The node to add.
     * @throws IllegalArgumentException - if node is in the enqueued state.
     */
    public void addAfter( DNode node ) throws IllegalArgumentException
    {
        if ( node.isEnqueued() )
            throw new IllegalArgumentException();
        
        node.blink = this;
        node.flink = this.flink;
        node.flink.blink = node;
        flink = node;
    }
    
    /**
     * Adds a new node before this one. 
     * The new node must be in the unenqueued state; if it is not, an exception will be thrown.
     * @param node - The node to add.
     * @throws IllegalArgumentException - if node is in the enqueued state.
     */
    public void addBefore( DNode node ) throws IllegalArgumentException
    {
        if ( node.isEnqueued() )
            throw new IllegalArgumentException();
        
        blink.addAfter( node );
    }
    
    /**
     * The user data stored in this node.
     * @return The user data stored in this node.
     */
    public Object getData()
    {
        return data;
    }
    
    /**
     * Sets the user data in this node.
     * @param data - The user data.
     */
    public void setData( Object data )
    {
        this.data = data;
    }
    
    /**
     * Returns the next node. If the node is unenqueued the node itself is returned. 
     * If the node is at the tail of a DList, a reference to the DList is returned.
     * 
     * Sample usage:
     *
     *<pre>
     *    DNode next = list.getHead();
     *    while ( next != list )
     *    {
     *        System.out.println( next.getData() );
     *        next = node.getNext();
     *    }
     *</pre>
     * 
     * @return The next node in the list, or itself if unenqueued.
     */
    public DNode getNext()
    {
        return flink;
    }
    
    /**
     * Returns the previous node. If the node is unenqueued the node itself is returned. 
     * If the node is at the head of a DList, a reference to the DList is returned.
     * 
     * Sample usage:
     *
     *<pre>
     *    DNode next = list.getTail();
     *    while ( next != list )
     *    {
     *        System.out.println( next.getData() );
     *        next = node.getPrevious();
     *    }
     *</pre>
     * 
     * @return The previous node in the list, or itself if unenqueued.
     */
    public DNode getPrevious()
    {
        return blink;
    }
    
    /**
     * Removes this node from the list it belongs to. 
     * If this node does not belong to a list, no action is taken. 
     * This node is returned.
     * @return This node.
     */
    public DNode remove()
    {
        if ( isEnqueued() )
        {   
            flink.blink = blink;
            blink.flink = flink;
            flink = this;
            blink = this;
        }
        
        return this;
    }
    
    /**
     * Returns true if this node is enqueued.
     * @return True if this node is enqueued, false otherwise.
     */
    public boolean isEnqueued()
    {
        return flink != this;
    }
    
    
}
