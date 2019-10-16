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
public class MiddleLL {
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

  static void FindMiddle(Node head,Node slow)
  {
    if(head.next==null||head.next.next==null)
    {
        System.out.println(slow.data);
        return;
    }
    else
      FindMiddle(head.next.next,slow.next);
  }
  public static void main(String args[])
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

    FindMiddle(head,head);
  }
}