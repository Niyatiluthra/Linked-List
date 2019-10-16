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
public class CheckLoop {
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

  static int findAndCountLoop(Node head) {
    Node slow = head;
    Node fast = head;
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

    head.next.next.next.next.next = head.next; 

    //printList(head);
    
    int count = findAndCountLoop(head);
    if(count!=0)
        System.out.println("Loop Found and no. of elements in loop are "+count);
    else
        System.out.println("Loop Not Found");
  }
}