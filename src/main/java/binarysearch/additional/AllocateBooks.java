package binarysearch.additional;


/*
*  // PROBLEM DESCRIPTION
* Given an array of integers A of size N and an integer B.
* The College library has N books. The ith book has A[i] number of pages.
* You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
*
* A book will be allocated to exactly one student.
* Each student has to be allocated at least one book.
* Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
*
* Calculate and return that minimum possible number.
* NOTE: Return -1 if a valid assignment is not possible.
*
* // PROBLEM CONSTRAINTS
*
* 1 <= N <= 10^5
* 1 <= A[i], B <= 10^5
*
* */


public class AllocateBooks {

    public int books(int[] A, int B){
        int n = A.length;
        // If number of students is greater than number of books, return -1
        if (B > n) return -1;
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i : A){
            sum+=i;
            min = Math.min(min, i);
        }
        int st = min;
        int end = sum;
        int ans = -1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(isPossible(A, B, mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                st = mid+1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] A, int B, int mid){
        int cnt = 1;
        int allocatedPages = 0;
        for (int j : A) {
            if (j > mid) return false;
            allocatedPages += j;
            if (allocatedPages > mid) {
                cnt++;
                allocatedPages = j;
            }
            if (cnt > B) return false;
        }
        return true;
    }

    // T.C - O(N*log(range)) where range -> (end - start) = (sum - min(A[i])
    // S.C - O(1)
}
