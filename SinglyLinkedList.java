package niyati_ds;

public class SinglyLinkedList <E>
{
  //---------------- nested Node class ----------------
  /*
   * Node of a singly linked list, which stores a reference to its
   * element and to the subsequent node in the list (or null if this
   * is the last node).
   */

  private static class Node <E> ///inner class node : 2 objects hote hai linked list mai ek node or pori linked list , base object hai node 
  {
    /* The element stored at this node */
    private E element;            // reference to the element stored at this node

    /* A reference to the subsequent node in the list */
    private Node next;         // reference to the subsequent node in the list

    public Node(E e, Node n) 
    {
      element = e;
      next = n;
    }
    /*
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */

    // Accessor methods
    /*
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() 
    {
      return element;
    }

    /*
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node getNext() 
    { 
      return next;
    }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node n) 
    { 
      next = n;
    }
  } //----------- end of nested Node class -----------


  // instance variables of the SinglyLinkedList
  /** The head node of the list */

  private Node<E> head = null;               // head node of the list (or null if empty)

  /** The last node of the list */
  private Node<E> tail = null;               // last node of the list (or null if empty)


  /** Number of nodes in the list */
  private int size = 0;                      // number of nodes in the list


  /** Constructs an initially empty list. */
  public SinglyLinkedList() 
  { 
    head=null;
    tail=null;
  }              // constructs an initially empty list


  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() 
  {  
    return size;
  }


  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() 
  { 
    if(head==null)
      return true;
    else
      return false;
  }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first()
  {
                 // returns (but does not remove) the first element
    if(isEmpty())
      return null;
    else
      return head.getElement(); 
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() 
  {              // returns (but does not remove) the last element
    if(isEmpty())
     return null;
    else
      return tail.getElement(); 
  }
  // update methods
  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) 
  {                // adds element e to the front of the list
    Node<E> temp = new Node<E>( e, head );
    head = temp;
    if(size==0)
      tail=head;
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) 
  {                 // adds element e to the end of the list\
    Node<E> temp2 = new Node<E>(e,null);
    if(tail==null)
    {
        addFirst(e);
    }
    else
    {
      tail.setNext(temp2);
      tail = temp2;
      size++;
    }
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() 
  {                   // removes and returns the first element
    if(isEmpty())
      return null;
    E temp = head.getElement();
    head = head.getNext();
    size--;
    if(size==0)
    {
      tail=null;
      head=null;
    }
    return temp;
  }

  /**
   * This function will add a new node between 2 nodes .
   * @param e will be the element to be inserted .
   * @param index will be the index after which element is to be inserted. 
   */
  public void addInBetween( E e, int index)
  {
    if(index>size)
    {
      System.out.println("Index is invalid");
    }
    else if (index<size)
    {
      Node <E> prev = head;
      for(int i=0;i<index-1;i++)
      {
        //System.out.println(prev.getElement()+"..");
        prev = prev.getNext();
      }
      Node <E> next = prev.getNext();
      Node <E> node = new Node<E> (e,next);
      prev.setNext(node);
      size++;
    }
    else if (index == size)
    {
      addLast(e);
    }
  }

  
  public int findAndCountLoop() {
    Node<E> slow = head;
    Node<E> fast = head;
    int temp = 0;
    while(slow!=null&&fast!=null&&fast.next!=null)
    {
      slow=slow.next;
      fast=fast.next.next;
      if(slow==fast)
      {
        temp=1;
        break;
      }
    }
    if(temp == 0)
      return 0;
    else 
    {
      int count = 0;
      slow = slow.next;
      while(slow!=fast)
      {
        slow=slow.next;
        count++;
      }
      return count+1;
    }
  }

  void removeLoop() {
		Node < E > slow = head;
    Node < E > fast = head;
    int temp=0;
		while (slow != null && fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (fast == slow)
      {	
        temp = 1;
        break;
      }
    }
    if(temp != 1)
      return;
      

		Node<E> temp1 = slow;
		Node<E> temp2 = slow;
		int count = 1, i;
		while (temp1.getNext() != temp2) {
			temp1 = temp1.getNext();
			count++;
		}

		temp1 = head;

		temp2 = head;
		for (i = 0; i < count; i++) {
			temp2 = temp2.getNext();
		}

		while (temp2 != temp1) {
			temp1 = temp1.getNext();
			temp2 = temp2.getNext();
		}

		while (temp2.getNext() != temp1) {
			temp2 = temp2.getNext();
		}

		temp2.setNext(null);
  }
  
  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() 
  {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }
}
