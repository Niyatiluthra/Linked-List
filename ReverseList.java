import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d)
    {
        data=d;
        next=null;
    }
}
public class ReverseList {
  static void insert(Node head,int data)
  {
    if(head==null)
    {
        head=new Node(data);
        return;
    }
    Node temp=head;
    while(temp.next!=null)
    {
        temp=temp.next;
    }
    temp.next = new Node(data);
  }

  static Node reverse(Node head)
  {
    if (head == null || head.next == null) 
        return head; 

    Node temp = reverse(head.next); 
    head.next.next = head; 

    head.next = null; 

    return temp; 
  }

  static void printList(Node head)
  {
    if(head==null)
      return;

    System.out.println(head.data);

    printList(head.next);
  }

  public static void main(String argjavas[])
  {
    Node head=new Node(1);
    insert(head,6);
    insert(head,5);
    insert(head,6);
    insert(head,1);
    insert(head,14);
    insert(head,85);
    insert(head,78);
    insert(head,9);
    insert(head,21);

    System.out.println("Before Reverse");
    printList(head);

    head = reverse(head);

    System.out.println("Before Reverse");
    printList(head);
  }
}