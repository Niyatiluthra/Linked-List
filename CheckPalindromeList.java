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
public class CheckPalindromeList {
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

  static Node check(Node head, Node slow)
  {
    if(head.next==null)
      return slow;
    else if(head.next.next==null)
    {  
      if(slow.data==slow.next.data)
        return slow.next;
      else 
        return null;
    }
    else
    {
      Node temp = check(head.next.next,slow.next);
      if(temp==null)
        return null;
      else 
      {
        
        if(slow.data==temp.next.data)
          return temp.next;
        else 
          return null;
      }
    }
  }
  static int checkPalindrome(Node head) {
    if(head==null)
      return 0;
    Node slow = head;
    Node temp = check(head,slow);
    if(temp==null)
      return 0;
    else
      return 1;
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

    printList(head);
    
    if(checkPalindrome(head)==1)
        System.out.println("Palidrome");
    else
        System.out.println("Not Palidrome");
  }
}