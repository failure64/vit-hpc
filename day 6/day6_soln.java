// Write a program to perform and implement a Circular single-linked list



// It should be a menu-driven program with the following functions:

// insert( )
// beginDelete(),
// lastDelete()
// randomDelete( )
// search(),
// display(),
// exit.
// Input format :
// The input consists of the choices.

// If the choice is 1, insert the elements.

// If the choice is 2, Delete the first element.

// If the choice is 3, Delete the last element

// If the choice is 4, enter the position to delete.

// If the choice is 5, enter the element to be searched.

// If the choice is 6, display.

// If the choice is 7, exit.

// If the choice is greater than 6, print "Invalid choice. Please try again."

// Output format :
// The output prints the results based on the choice. [If the searched element is present, print 1, else print -1].

// Sample test cases :
// Input 1 :
// 1
// 88
// 1
// 67
// 1
// 54
// 1
// 64
// 1
// 34
// 6
// 5
// 67
// 2
// 3
// 1
// 234
// 4
// 64
// 6
// 9
// 7

// Output 1 :
// Node with data 88 inserted.
// Node with data 67 inserted.
// Node with data 54 inserted.
// Node with data 64 inserted.
// Node with data 34 inserted.
// Circular Linked List: 34 64 54 67 88 
// Node with data 67 found at position 4.
// Node at the beginning deleted.
// Node at the end deleted.
// Node with data 234 inserted.
// Node with data 64 deleted.
// Circular Linked List: 234 54 67 
// Invalid choice. Please try again.



// You are using Java
import java.util.*;
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedL{
    private Node head;
    public LinkedL(){
        this.head  = null;
    }
    
    public void insert(int data){
        Node nod = new Node(data);
        if(head == null){
            head = nod;
            nod.next = head;
        }else{
            Node curr = head;
            while(curr.next != head){
                curr=curr.next;
            }
            curr.next = nod;
            nod.next=head;
            head = nod;
        }
        System.out.println("Node with data "+data+" inserted.");
    }
    public void beginDelete(){
        // Node nod = new Node(data);
        if(head == null){
            System.out.println("Circular Linked List is  empty.");
            return;
        }
        if(head.next == head){
            head = null;
        }else{
            Node curr = head;
            while(curr.next != head){
                curr=curr.next;
            }
            curr.next = head.next;
            head = head.next;
        }
        System.out.println("Node at the beginning deleted.");
    }
    
    public void lastDelete(){
        // Node nod = new Node(data);
        if(head == null){
            System.out.println("Circular Linked List is  empty.");
            return;
        }
        if(head.next == head){
            head = null;
        }else{
            Node curr = head;
            Node prev = null;
            while(curr.next != head){
                prev = curr;
                curr=curr.next;
            }
            prev.next = head;
        }
        System.out.println("Node at the end deleted.");
    }
    
    public void randomDelete(int data){
        // Node nod = new Node(data);
        if(head == null){
            System.out.println("Circular Linked List is  empty.");
            return;
        }
        if(head.data == data){
            beginDelete();
            return;
        }
        
            Node curr = head;
            Node prev = null;
            boolean found = false;
            do{
                
                if(curr.data == data){
                    found = true;
                    break;
                }
                prev = curr;
                curr=curr.next;
            }
            while(curr != head);
            if(found == false){
                System.out.println("Node with data "+data+"not found.");
                return;
            }
            prev.next = curr.next;
        
        System.out.println("Node with data "+data+" deleted.");
    }
    
    public void search(int data){
        // Node nod = new Node(data);
        if(head == null){
            System.out.println("Circular Linked List is  empty.");
            return;
        }
        
            Node curr = head;
            
            boolean found = false;
            int pos =1;
            do{
                
                if(curr.data == data){
                    found = true;
                    break;
                }
                // prev = curr;
                curr=curr.next;
                pos++;
            }
            while(curr != head);
            if(found == false){
                System.out.println("Node with data "+data+"not found.");
            }else
                System.out.println("Node with data "+data+" found at position "+pos+".");
    }
    
    public void display(){
        // Node nod = new Node(data);
        if(head == null){
            System.out.println("Circular Linked List is  empty.");
            return;
        }
            System.out.print("Circular Linked List: ");
        
            Node curr = head;
            
            do{
            System.out.print(curr.data+" ");
                
                // if(curr.data == data){
                //     found = true;
                //     break;
                // }
                // prev = curr;
                curr=curr.next;
            }
            while(curr != head);
                System.out.println();
    }
    
    
}

public class Main{
    public static void main(String args[]){
        LinkedL ll = new LinkedL();
        Scanner sc = new Scanner(System.in);
        int ch;
        int data;
        while(true){
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    data =sc.nextInt();
                    ll.insert(data);
                    break;
                case 2:
                    // data =sc.nextInt():
                    ll.beginDelete();
                    break;
                case 3:
                    // data =sc.nextInt():
                    ll.lastDelete();
                    break;
                case 4:
                    data =sc.nextInt();
                    ll.randomDelete(data);
                    break;
                case 5:
                    data =sc.nextInt();
                    ll.search(data);
                    break;
                case 6:
                    // data =sc.nextInt():
                    ll.display();
                    break;
                case 7:
                    System.exit(0);
                default:
                System.out.println("Invalid choice.Please try again.");
                
            }
        }
    }
}
