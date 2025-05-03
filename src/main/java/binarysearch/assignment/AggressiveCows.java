package binarysearch.assignment;


import java.util.Arrays;

/*
* // Problem Description

Farmer John has built a new long barn with N stalls.
* Given an array of integers A of size N where each element of the array represents the location of the stall
* and an integer B which represents the number of cows.
* His cows don't like this barn layout and become aggressive towards each other once put into a stall.
* To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
* such that the minimum distance between any two of them is as large as possible.
* What is the largest minimum distance?
*
* // Problem Constraints
* 2 <= N <= 100000
* 0 <= A[i] <= 10^9
* 2 <= B <= N
*
*
* */
public class AggressiveCows {

    public int solve(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);
        int st = 1;
        int end = A[n-1];
        int ans = -1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(isPossible(A, B, mid)){
                ans = mid;
                st = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] A, int B, int minDist){
        int cnt = 1;
        int last = A[0];
        for(int i=1; i<A.length; i++){
            if(A[i]-last >= minDist){
                cnt++;
                last = A[i];
            }
        }
        return cnt>=B;
    }

    // TC = O(N*log(range)) - range -> A[n-1] - 1
    // SC = O(1)
}
