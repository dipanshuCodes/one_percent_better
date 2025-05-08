package binarysearch.assignment;

/*
* // PROBLEM DESCRIPTION
* Given an integer A. Compute and return the square root of A.
* If A is not a perfect square, return floor(sqrt(A)).
* NOTE:
* The value of A*A can cross the range of Integer.
* Do not use the sqrt function from the standard library.
* Users are expected to solve this in O(log(A)) time.
*
* // PROBLEM CONSTRAINTS
*
* 0 <= A <= 10^9
*
* */
public class SquareRoot {
    public int sqrt(int A) {
        if(A==0) return 0;
        long st = 1;
        long end = A;
        int ans = 1;
        while(st<=end){
            long mid = st + (end-st)/2;
            if(mid*mid<=A){
               ans = Math.max(ans, (int)Math.floor(mid));
               st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }

    //T.C = O(log(A))
    //S.C = O(1)
}
