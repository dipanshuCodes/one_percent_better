package binarysearch.additional;

import java.util.*;

/*
* // PROBLEM DESCRIPTION
*
* Given an integer array A of size N.
* If we store the sum of each triplet of the array A in a new list, then find the Bth smallest element among the list.
* NOTE: A triplet consists of three elements from the array. Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.
*
* // CONSTRAINTS
*
* 3 <= N <= 500
* 1 <= A[i] <= 10^8
* 1 <= B <= (N*(N-1)*(N-2))/6
* */
public class FindSmallestAgain {

    public int bruteForce(int[] A, int B){
        int n = A.length;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                for(int k = j+1; k<n; k++){
                    list.add((A[i]+A[j]+A[k]));
                }
            }
        }

        Collections.sort(list);
        return list.get(B-1);

    }

    //T.C - O(n^3 + MlogM) ;  M = nC3 ~ n*(n-1)*(n-2)/6 ~ n^3  ; O(n^3log(n^3))
    //S.C - O(n^3)


    /*
    * // INTUITION
    * The triplet sum will lie between a range of sum of first 3 indexes and the last 3 indexes when given array is sorted.
    * Now, by applying binary search on this, for a particular 'mid'.
    * We can calculate the number of triplets with sum<=mid, if this count is < B ; surely answer lies in the right.
    * else if cnt>=B - this can be one of the answer and then move left to see if we can have better answer.
    *
    * Eg - Consider triplets sum - {7, 8, 9, 9, 9, 9, 10, 10} and B = 4;
    * for mid = 8 - we'll receive 2, therefore answer lies in right
    * for mid = 10; we'll receive 8, now we can consider 10 as one of the possible answers because there can be repetitions of 10s all across ;
    * but we'll still move to left to check if better answer exists
    * for mid = 9, we receive 6, which is again >4 and since this is better than 10, we update our answer to 9.
    * now because st and end are pointing to 9 and after we move left, st crosses end, we can say that 9 is the best possible answer.
    *
    * */

    public int solve(int[] A, int B){
        int n = A.length;
        Arrays.sort(A);
        int st = A[0]+A[1]+A[2];
        int end = A[n-1] + A[n-2] + A[n-3];
        int ans = -1;
        while(st<=end){
            int mid = st + (end-st)/2;
            int cnt = countTripletsOptimal(A, mid);
           if(cnt>=B){
               ans = mid;
               end = mid-1;
           } else st = mid+1;


        }
        return ans;
    }

    //T.C - O(n*logn + n^2*log(n)*log(3*max(A))
    //S.C - O(1)



    // brute force O(n^3) approach to count the triplet sum
    private int countTripletsWithSumLessThan(int[] A, int num){
        int n = A.length;
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = i+1;j<n; j++){
                for(int k = j+1; k<n; k++){
                    int sum = A[i]+A[j]+A[k];
                    if(sum<=num)cnt++;
                }
            }
        }
        return cnt;
    }

    // optimised version of counting the triplet sum by making use of lastOccurence of an element by using B.S.
    private int countTripletsOptimal(int[] A, int num){
        int n = A.length;
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j = i+1; j<n; j++){
                    int lastIndex = lastOccurrence(A, num-(A[i]+A[j]));
                    if(lastIndex>j){
                        cnt+=(lastIndex - j);
                    }
            }
        }
        return cnt;
    }
    //T.C - O(n^2*log(n))


    // lastOccurrence - finding the index of the last number which is less than or equal to given number.
    private int lastOccurrence(int[] A, int num){
        int n = A.length;
        int st = 0;
        int end = n-1;
        int ans = -1;
        while(st<=end){
            int mid = (st+end)/2;
            if(A[mid]<=num){
                ans = mid;
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    //T.C - O(log(N))
}
