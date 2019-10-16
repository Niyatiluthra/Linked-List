package niyati_ds;

public class CircularlyLinkedList<E> 
{
  //---------------- nested Node class ----------------
  /**
   * Singly linked node, which stores a reference to its element and
   * to the subsequent node in the list.
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;     // an element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;  // a reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) 
    {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() 
    {
      return element;
    }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() 
    {
      return next;
    }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) 
    {
      next = n;
    }
  } //----------- end of nested Node class -----------

  // instance variables of the CircularlyLinkedList
  /** The designated cursor of the list */
  private Node<E> tail = null;                  // we store tail (but not head)

  /** Number of nodes in the list */
  private int size = 0;                         // number of nodes in the list

  /** Constructs an initially empty list. */
  public CircularlyLinkedList() 
  { 
    tail = null;
    size = 0;
  }             // constructs an initially empty list

  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { 
    return size;
   }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() {  
    return tail == null;
  }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first() 
  {     
            // returns (but does not remove) the first element
    return tail.getNext().getElement();
  }

  /**
   * Returns (but does not remove) the last element of the list
   * @return element at the back of the list (or null if empty)
   */
  public E last() {  
    return tail.getElement();            // returns (but does not remove) the last element
   }

  // update methods
  /**
   * Rotate the first element to the back of the list.
   */
  public void rotate() {  
           // rotate the first element to the back of the list
           Node <E> head = tail.getNext();
           tail = head;
           tail.setNext(head.getNext());
   }

  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {   
    if(isEmpty())
    {
      Node <E> node = new Node <E> (e,null);
      tail=node;
      tail.setNext(node);
    }
    else
    {
      Node <E> node = new Node <E> (e,tail.getNext());
      tail.setNext(node);
    }      
    size++;   // adds element e to the front of the list
   }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) { 
    if(isEmpty())
    {
      Node <E> node = new Node <E> (e,null);
      tail = node;
      tail.setNext(node);
      size++;
    }
    else
    {
      Node <E> node = new Node <E> (e,tail.getNext());
      tail = node;  
      size++;
    }             // adds element e to the end of the list
   }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() 
  {  
    Node<E> head = tail.getNext();
    E x = head.getElement(); 
    tail.setNext(head.getNext());  
    size--;   
    return x;     // removes and returns the first element
   }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
    StringBuilder x = new StringBuilder("");
    Node <E> temp = tail.getNext();
    for(int i =0;i<size-1;i++)
    {
      x.append(temp.getElement());
      x.append(",");
      temp = temp.getNext();
    }
    E last = tail.getElement();
    x.append(last);
    return x.toString();
   }
}
