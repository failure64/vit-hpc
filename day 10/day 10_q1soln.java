// Math Club's Postfix to Infix Converter



// The Math Club at St. Joseph's High School has been working on developing a handy tool to convert postfix expressions to infix expressions. They have approached you, an expert in programming and data structures, to help them build this tool. The club members want to use the tool to quickly convert postfix expressions into infix expressions for their math assignments and competitions.

// Input format :
// The input consists of a postfix expression in string format.

// Output format :
// The output prints the postfix expression to the infix expression in string format.

// Sample test cases :
// Input 1 :
// xy/z-
// Output 1 :
// ((x/y)-z)
// Input 2 :
// ab*c+
// Output 2 :
// ((a*b)+c)


// You are using Java
import java.util.*;
class Main{
    static boolean isOperand(char x){
        return (x>='a' && x<='z') || (x>='A' && x<='Z');
    }
    static String getInfix(String exp){
        Stack <String> s = new Stack<String>();
        for(int i=0;i<exp.length();i++){
            if(isOperand(exp.charAt(i))){
                s.push(exp.charAt(i)+"");
            }else{
                String op1 =s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                s.push("(" + op2+exp.charAt(i)+ op1+")");
            }
        }
        return s.peek();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        System.out.println(getInfix(exp));
    }
}
