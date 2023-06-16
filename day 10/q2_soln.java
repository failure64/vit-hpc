
// Supermarket Point of Sale System



// The company has been hired as a software engineer at a leading supermarket chain. The task is to develop a point of sale (POS) system that can handle arithmetic calculations for the cashiers. The supermarket wants to provide a feature that allows cashiers to enter arithmetic expressions in postfix notation and receive the calculated result instantly.

// Input format :
// The first line of the input consists of the array size.

// The second line of the input contains a postfix expression based on the array size in separate lines.

// Output format :
// The output prints an integer, representing the details of the evaluation of the postfix expression and printing of the value.

// Code constraints :
// 1 <= T <= 100

// 1 <= length of expression <= 100

// Sample test cases :
// Input 1 :
// 2
// 231*+9-
// 123+*8-
// Output 1 :
// -4
// -3
// Input 2 :
// 1
// 531+/9-
// Output 2 :
// -8


// You are using Java
import java.util.*;
class Main{
    static int Postfix(String exp){
        Stack <Integer> s= new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(Character.isDigit(c))
            s.push(c-'0');
            else{
                int val1 = s.pop();
                int val2 = s.pop();
                switch(c){
                    case '+':
                        s.push(val2+val1);
                        break;
                    case '-':
                        s.push(val2-val1);
                        break;
                    case '*':
                        s.push(val2*val1);
                        break;
                    case '/':
                        s.push(val2/val1);
                        break;
                }
            }
        }
        return s.pop();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            String exp = sc.next();
            System.out.println(Postfix(exp));
            t--;
        }
    }
}
