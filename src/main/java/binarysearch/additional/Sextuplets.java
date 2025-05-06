package binarysearch.additional;

import java.util.HashMap;

/*
* // PROBLEM DESCRIPTION
* Given an array of integers A, find the number of sextuplets that satisfy the equation ( (a * b + c) / d ) - e = f.
* Where a, b, c, d, e, f belong to the given array A.
* NOTE: Since the answer can be very large, return the number of ways modulo (10^9 + 7).
*
* // PROBLEM CONSTRAINTS
* 1 <= |A| <= 100
* -10^6 <= A[i] <= 10^6
* All elements of array A are distinct.
* */
public class Sextuplets {

    int MOD = 1000000007;
    //equation can be re-written as
    // (a*b + c) = d*(e + f)
    public int solve(int[] A) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int item : A) {
            for (int i : A) {
                for (int j : A) {
                    int calc = item * i + j;
                    map.put(calc, map.getOrDefault(calc, 0) + 1);
                }
            }
        }

        int ans = 0;
        for (int value : A) {
            if(value == 0) continue;
            for (int i : A) {
                for (int j : A) {
                    int calc = value * (i + j);
                    ans = ans + map.getOrDefault(calc, 0);
                }
            }
        }

        return ans%MOD;
    }

    //T.C for Brute force - O(n^6)
    //T.C = O(n^3)
    //S.C = O(n^3)
}
