package binarysearch.additional;

import java.util.*;

/*
* // PROBLEM DESCRIPTION
* Given an array of integers A of size N and an integer B.
* In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.
* Find the number with the maximum number of occurrences and return an array C of size 2,
* where C[0] is the number of occurrences, and C[1] is the number with maximum occurrence.
* If there are several such numbers, your task is to find the minimum one.
*
* // PROBLEM CONSTRAINTS
* 1 <= N <= 10^5
* -10^9 <= A[i] <= 10^9
* 0 <= B <= 10^9
*
* */
public class AddOrNot {

    public int[] bruteForce(int[] A, int B) {
        // Count frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Get unique numbers and sort them
        List<Integer> uniqueNumbers = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(uniqueNumbers);
        
        int maxOccurrences = 0;
        int targetNumber = uniqueNumbers.getFirst();
        
        // Try to make each number the most frequent
        for (int currentNum : uniqueNumbers) {
            int currentOccurrences = frequencyMap.get(currentNum);
            int remainingOperations = B;
            
            // Try to make smaller numbers equal to current number
            for (int i = uniqueNumbers.indexOf(currentNum) - 1; i >= 0; i--) {
                int smallerNum = uniqueNumbers.get(i);
                int smallerNumCount = frequencyMap.get(smallerNum);
                int operationsNeeded = (currentNum - smallerNum) * smallerNumCount;
                
                if (remainingOperations >= operationsNeeded) {
                    // We can make all smaller numbers equal to current number
                    remainingOperations -= operationsNeeded;
                    currentOccurrences += smallerNumCount;
                } else {
                    // We can make some of the smaller numbers equal to current number
                    int possibleCount = remainingOperations / (currentNum - smallerNum);
                    currentOccurrences += possibleCount;
                    break;
                }
            }
            
            // Update result if we found better answer
            if (currentOccurrences > maxOccurrences) {
                maxOccurrences = currentOccurrences;
                targetNumber = currentNum;
            }
        }
        
        return new int[]{maxOccurrences, targetNumber};
    }
    //T.C =O(N + N*log(N) + N^2) = O(N^2)
    //S.C = O(N + N) = O(N)

    // BS SOLUTION

    /*
    * // INTUITION
    * We'll increase the numbers in the left nearest order.
    * Now, let's apply BS on the count and check if we can achieve the count in B operations.
    * To calculate the sum - think of prefix sum array using which we can count the sum for the 'cnt' elements.
    * # of Ops = Actual sum - prefixSum ; Actual Sum = cnt*A[i];
    * */

    public int[] solve(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;
        long[] prefixSum = new long[n+1];
        prefixSum[0] = 0;


        for(int i = 0; i<n; i++){
            prefixSum[i+1] = A[i] + prefixSum[i];
        }

        int num = 1_000_000_001;
        int freq = 0;
        for(int i = 0; i<n; i++){
            int maxPossibleFreq = i+1;
            int st = 1;
            int end = maxPossibleFreq;

            while(st<=end){
                int mid = (st+end)/2;
                long sumReqd = (long)mid*A[i];
                long actualSum = prefixSum[i+1] - prefixSum[i+1-mid];
                long opsReqd = sumReqd - actualSum;
                if(opsReqd<=B){
                    if(mid>freq){
                        freq = mid;
                        num = A[i];
                    }
                    st = mid+1;

                }else{
                    end = mid-1;
                }
            }
        }
        return new int[]{freq, num};
    }

    //T.C - O(NlogN + N + Nlog(N)) = O(Nlog(N)) ; // Sorting + Prefix sum calculation + BS for each number in A.
    //S.C - O(N) ; // PrefixSum array
}
