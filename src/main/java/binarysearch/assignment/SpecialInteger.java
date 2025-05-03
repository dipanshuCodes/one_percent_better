package binarysearch.assignment;


/*
* // Problem Description
* Given an array of integers A and an integer B, find and return the maximum value K
* such that there is no subarray in A of size K with the sum of elements greater than B.
*
* // Problem Constraints
* 1 <= |A| <= 100000
* 1 <= A[i] <= 10^9
* 1 <= B <= 10^9
*
* */
public class SpecialInteger {

    public int solve(int[] A, int B) {
        int n = A.length;
        int st = 0;
        int end = n;
        int ans = 0;
        while(st<=end){
            int mid = (st+end)/2;
            if(isPossible(A, mid, B)){
                ans = mid;
                st = mid+1;
            }
            else{
                end = mid-1;
            }

        }
        return ans;
    }

    private boolean isPossible(int[] A, int mid, int B){
        int n = A.length;
        int sum = 0;
        int ans = 0;
        for(int i = 0; i<mid; i++){
            sum+=A[i];
            ans = sum;
            if(sum>B) return false;
        }
        for(int i = mid; i<n; i++){
            sum += A[i] - A[i-mid];
            ans = Math.max(ans, sum);
            if(ans>B) return false;
        }

        return true;
    }

    // TC = O(N*log(N))
    // SC = O(1)

}
