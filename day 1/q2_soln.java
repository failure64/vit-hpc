// Problem Statement

// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.



// Examples



// Input:

// 6

// 2 1 5 6 2 3

// Output:

// 10

// Explanation:

// The above is a histogram where the width of each bar is 1.

// The largest rectangle is shown in the red area, which has an area = 10 units.



// Input:

// 2

// 2 4

// Output:

// 4

// Explanation:

// Input format :
// The input consists of two lines:

// The first line contains a single integer n (1 <= n <= 105), representing the number of heights in the array.

// The second line contains n space-separated integers representing the heights of the array.

// Output format :
// The output consists of a single integer, which represents the area of the largest rectangle that can be formed using the given heights.

// Code constraints :
// 1 <= heights.length <= 105

// 0 <= heights[i] <= 104

// Sample test cases :
// Input 1 :
// 6
// 2 1 5 6 2 3
// Output 1 :
// 10
// Input 2 :
// 2
// 2 4
// Output 2 :
// 4


// You are using Java
import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h[] =new int[n];
        for(int i=0;i<n;i++){
            h[i] = sc.nextInt();
        }
        if(h==null || n==0){
            System.out.println(0);
        }
        Stack<Integer> s = new Stack<>();
        int max =0;
        int i=0;
        while(i<n){
            if(s.isEmpty() || h[i] >= h[s.peek()]){
                s.push(i);
                i++;
            }else {
                int p = s.pop();
                int a = h[p];
                int w = s.isEmpty() ? i: i-s.peek()-1;
                max = Math.max(a*w, max);
            }
            }
            while(!s.isEmpty()){
                int p = s.pop();
                int a = h[p];
                int w = s.isEmpty() ? i: i-s.peek()-1;
                max = Math.max(a*w, max);
            }
        System.out.println(max);
    }
}
