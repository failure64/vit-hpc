// Problem statement
// Write a Program to implement the stack using a linked list. Get the values continuously from the user until the user enters a negative value.

// Input format :
// The input consists of positive integers.

// The last input should be a negative value indicating the end of the inputs.

// Output format :
// The output displays the stack of numbers separated by space.

// Code constraints :
// The input values can be positive, negative, or zero.

// Sample test cases :
// Input 1 :
// 1
// 2
// 3
// 4
// -1
// Output 1 :
// 4 3 2 1 
// Input 2 :
// 10
// 20
// 0
// -1
// Output 2 :
// 0 20 10 
// Input 3 :
// -1
// Output 3 :
// Stack Underflow



// You are using Java
import java.util.*;
class Stack{
    public class Node{
        int data;
        Node link;
    }
    Node top;
    Stack(){
        this.top = null;
    }
    
    public void push(int data){
        Node temp = new Node();
        
        if(temp == null){
            return;
        }
        temp.data = data;
        temp.link =top;
        top=temp;
    }
    
    public void prin(){
        if(top==null){
            System.out.println("Stack Underflow");
        }else{
            Node temp = top;
            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.link;
            }
        }
    }
}

public class Main{
    public static void main(String args[]){
        Stack a = new Stack();
        Scanner sc = new Scanner(System.in);
        while(true){
            int data = sc.nextInt();
            if(data>=0){
                a.push(data);
            }else{
                break;
            }
        }
        a.prin();
    }
}
