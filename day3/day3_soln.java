
// Question No: 1
// Single File Programming Question
// Problem Statement



// Write a program to evaluate a polynomial using a linked list representation.



// The program should take a polynomial and a value of x as input from the user and output the value of the polynomial at that point.



// Example



// Input:

// 2

// 13

// 12

// 11

// 1



// Output:

// 36



// Explanation:

// Calculate the value of x2: 13 * 12 = 13.

// Calculate the value of x1: 12 * 11 = 12.

// Calculate the value of x0: 11 * 10 = 11.

// Add the values of x2, x1, and x0 together: 13 + 12 + 11 = 36

// Output the result as an integer. 36

// Input format :
// The first line of input consists of the degree of the polynomial.

// The second line of input consists of the coefficient x2.

// The third line of input consists of the coefficient of x1.

// The fourth line of input consists of the coefficient x0.

// The fifth line of input consists of the value of x, at which the polynomial should be evaluated.



// Refer to the sample input for a better understanding.

// Output format :
// The output is the integer value obtained by evaluating the polynomial at the given value of x.

// Sample test cases :
// Input 1 :
// 2
// 13
// 12
// 11
// 1
// Output 1 :
// 36
// Input 2 :
// 2
// 15
// 16
// 18
// 1
// Output 2 :
// 49


// You are using Java
import java.util.*;

class Node{
    int coef;
    int exp;
    Node next;
    
    public Node(int coef,int exp){
        this.coef =coef;
        this.exp =exp;
        this.next =null;
    }
}

class Polynomial{
    Node head;
    public Polynomial(){
        this.head=null;
    }
    
    public void add(int coef, int exp){
        Node newNode = new Node(coef, exp);
        if(head == null)
        head = newNode;
        else{
            Node curr = head;
            while(curr.next !=null){
                curr=curr.next;
            }
            curr.next = newNode;
        }
    }

    
    public int eval(int x){
        int res =0;
        Node curr = head;
        while(curr != null){
            res += curr.coef * Math.pow(x, curr.exp);
            curr = curr.next;
        }
        // res += curr.coef;
        return res;
    }
}
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Polynomial poly = new Polynomial();
        
        int num = sc.nextInt();
        int n = num;
        for(int i=0;i<=num;i++){
            int coef = sc.nextInt();
            poly.add(coef,n);
            n--;
    
        }
        int x = sc.nextInt();
        System.out.println(poly.eval(x));
        
    }
}
