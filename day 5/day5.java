


// Write a program to perform and implement a doubly linked list.



// It should be a menu-driven program with the following functions:

// insertFront();
// insertEnd();
// insertPos();
// traverse();
// exit.
// Input format :
// The input consists of the choices.

// If the choice is 1, Enter the element to be inserted at the front.

// If the choice is 2, Enter the element to be inserted at the end

// If the choice is 3, Enter the position and the element to be inserted.

// If the choice is 4, Traverse and display the list.

// If the choice is 5, exit.

// If the choice is greater than 5, print "Invalid choice. Please try again."

// Also, if the position <=0 or current node == null, then print "Invalid position."

// Output format :
// The output prints the results based on the choice.

// Sample test cases :
// Input 1 :
// 1
// 23
// 1
// 45
// 1
// 67
// 1
// 89
// 1
// 234
// 1
// 167
// 2
// 34
// 3
// 67
// 3
// 4
// 8
// 5
// Output 1 :
// Node with data 23 inserted at the front.
// Node with data 45 inserted at the front.
// Node with data 67 inserted at the front.
// Node with data 89 inserted at the front.
// Node with data 234 inserted at the front.
// Node with data 167 inserted at the front.
// Node with data 34 inserted at the end.
// Node with data 67 inserted at position 3.
// Doubly Linked List: 167 234 67 89 67 45 23 34 
// Invalid choice. Please try again.



// You are using Java
import java.util.*;
class Node{
    int data;
    Node prev;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedL{
    private Node head;
    private Node tail;
    
    public LinkedL(){
        this.head=null;
        this.tail=null;
    }
    
 
    public void insertFront(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next=head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Node with data "+data+" inserted at the front.");
    }
    public void insertEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next=newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Node with data "+data+" inserted at the end.");
    }
    
    public void insertPos(int data, int pos){
        if(pos<=0){
            System.out.println("Invalid position.");
            return;
        }
        Node nod = new Node(data);
        if(pos==1){
            if(head == null){
                head = nod;
                tail=nod;
            }else{
                nod.next = head;
                head.prev = nod;
                head = nod;
            }
        }else{
            Node curr =head;
            int cnt =1;
            while(cnt<pos-1 && curr!=null){
                curr=curr.next;
                cnt++;
            }if(curr==null){
                System.out.println("Invalid position.");
                return;
            }
            nod.prev = curr;
            nod.next = curr.next;
            if(curr.next != null){
                curr.next.prev = nod;
            }else
            tail=nod;
            curr.next = nod;
        }
        System.out.println("Node with data "+data+" inserted at position "+pos+".");
        
    }
    
    public void traverse(){
        if(head == null){
            System.out.println("Doubly Linked List is empty.");
            return;
        }
        System.out.print("Doubly Linked List: ");
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        LinkedL ll = new LinkedL();
        int ch;
        int data;
        while(true){
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    data = sc.nextInt();
                    ll.insertFront(data);
                    break;
                case 2:
                    data = sc.nextInt();
                    ll.insertEnd(data);
                    break;
                case 3:
                    data = sc.nextInt();
                    int pos = sc.nextInt();
                    ll.insertPos(data,pos);
                    break;
                case 4:
                    ll.traverse();
                    break;
                case 5:
                    System.exit(0);
                    
                default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
    }
}
