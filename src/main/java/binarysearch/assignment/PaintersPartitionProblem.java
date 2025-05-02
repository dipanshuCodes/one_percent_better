package binarysearch.assignment;

/*
*  // Problem Description
* Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
Return the ans % 10000003.
*
*
* // Problem Constraints
1 <= A <= 1000
1 <= B <= 10^6
1 <= N <= 10^5
1 <= C[i] <= 10^6
*
* */

public class PaintersPartitionProblem {
    int MOD = 10000003;
    public int paint(int A, int B, int[] C){

        long sum = 0;
        long max = 0;
        for(int i : C){
            sum= (sum+i);
            max = Math.max(max, i);
        }
        long minTime = (max%MOD * B%MOD)%MOD;
        long maxTime = (sum%MOD *B%MOD)%MOD;
        long ans = maxTime;
        while(minTime <= maxTime){
            long mid = minTime + (maxTime - minTime)/2;
            int cnt = countOfPainters(mid, B, C);
            if(cnt<=A){
                ans = mid;
                maxTime = mid-1;
            }
            else
                minTime = mid+1;
        }

        return (int)(ans%MOD);
    }

    private int countOfPainters(long X, int B, int[] C){
        int cnt = 1;
        long time = X;
        for(int i : C){
            if((long)i *B > X) return -1;
            if((long)i *B <= time){
                time = (time - (long)i*B);
            }
            else{
                cnt+=1;
                time = (X - (long)i*B);
            }
        }
        return cnt;
    }

    // T.C = O(N*log(maxTime - minTime))
    // S.C = O(1)
}
