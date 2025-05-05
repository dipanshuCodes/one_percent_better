package binarysearch.assignment;


/*
* // PROBLEM DESCRIPTION
* Given a sorted array of integers A of size N and an integer B,
* where array A is rotated at some pivot unknown beforehand.
* For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
* Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
* You can assume that no duplicates exist in the array.
* NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
*
* // PROBLEM CONSTRAINTS
* 1 <= N <= 1000000
* 1 <= A[i] <= 10^9
* All elements in A are Distinct.
*
*  */

public class RotatedSortedArraySearch {

    public int search(final int[] A, int B) {
        int n = A.length;
        int st = 0;
        int end = n-1;
        while(st<=end){
            int mid = (st+end)/2;
            if(A[mid] == B){
                return mid;
            }
            if(B >= A[0])
            {
                if(A[mid] >= A[0])
                {
                    if(A[mid] < B) st = mid+1;
                    else end = mid - 1;
                }
                else end = mid - 1;
            }
            else
            {
                if(A[mid]>=A[0]) st = mid+1;
                else
                {
                    if(A[mid]<B) st = mid+1;
                    else end = mid - 1;
                }
            }
        }
        return -1;
    }

    // T.C - O(log(N))
    // S.C - O(1)
}
