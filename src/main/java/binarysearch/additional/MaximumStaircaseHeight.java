package binarysearch.additional;

/*
* // PROBLEM DESCRIPTION
* Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
* The first stair would require only one block, and the second stair would require two blocks, and so on.
* Find and return the maximum height of the staircase.
*
* // PROBLEM CONSTRAINTS
* 0 <= A <= 10^9
*
 * */
public class MaximumStaircaseHeight {
    public int solve(int A){
        int st = 0;
        int end = A;
        int ans = 0;
        while(st<=end){
            int mid = st + (end-st)/2;
            if ((long)mid*(mid+1) > (long)2*A){
               end = mid-1;
            }
            else{
                ans = mid;
                st = mid+1;
            }
        }
        return ans;
    }

    //T.C = O(log(A))
    //S.C = O(1)
}
