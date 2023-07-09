// Lalit and his friends are playing cards sitting around a circular table. After the first game, the first-person and last-person exchange their position. Pranav is watching this game and he relates this with Circular Linked List.



// So he decided to write a program to exchange the first and last nodes in Circular Linked List. Help Pranav to complete this program.

// Input format :
// The first line consists of a number of elements.

// The second line consists of N number of elements.

// Output format :
// The output prints the elements before the swap in the first line.

// The output prints the elements after the swap in the second line.

// Sample test cases :
// Input 1 :
// 10
// 3 4 5 6 7 8 1 2 3 9
// Output 1 :
// Before Swap: 3 4 5 6 7 8 1 2 3 9 
// After Swap: 9 4 5 6 7 8 1 2 3 3 



// You are using Java
import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Before Swap: ");
        for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
        }
        System.out.println();
        
        int temp = arr[0];
        arr[0]=arr[n-1];
        arr[n-1]=temp;
        System.out.print("After Swap: ");
        
        for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
        }
    }
}
