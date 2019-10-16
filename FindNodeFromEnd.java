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
public class FindNodeFromEnd {
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

  static void FindNode(Node head,int n)
  {
    Node temp = head;
    int length = 0;

    while (temp != null) { 
        temp = temp.next; 
        length++;
    } 

    if (length < n) 
        return; 

    temp = head; 

    for (int i = 0; i < length - n; i++) 
        temp = temp.next; 

    System.out.println(temp.data); 
  }

  static void printList(Node head)
  {
    if(head==null)
      return;

    System.out.println(head.data);

    printList(head.next);
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

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    FindNode(head,n);

  }
}