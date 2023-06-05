//Q1 Problem Statement

// Given an array, Arr[] of N integers, find the contiguous sub-array (containing at least one number) that has the maximum sum, and return its sum.
// Example 1
// Input:
// N = 5

// Arr[] = {1,2,3,-2,5}

// Output: 9

// Explanation: Max subarray sum is 9 of the elements (1, 2, 3, -2, 5), which is a contiguous subarray.

// Example 2
// Input:

// N = 4

// Arr[] = {-1,-2,-3,-4}

// Output: -1

// Explanation: Max subarray sum is -1 of element (-1)

// Input format :
// The first line of input contains an integer n, which represents the size of the array.

// The second line of input contains n space-separated integers, which represent the elements of the array.

// Output format :
// The output contains a single integer, which represents the maximum subarray sum of the given array.

// Code constraints :
// 1 ≤ N ≤ 106

// -107 ≤ A[i] ≤ 107

// Sample test cases :
// Input 1 :
// 5
// 1 2 3 -2 5
// Output 1 :
// 9
// Input 2 :
// 4
// -1 -2 -3 -4 
// Output 2 :
// -1
// You are using Java


import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] =new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int cur =0;
        int max =Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            cur+=arr[i];
            max = Math.max(max,cur);
            if(cur<0){
                cur=0;
            }
        }
        System.out.println(max);
    }
}
