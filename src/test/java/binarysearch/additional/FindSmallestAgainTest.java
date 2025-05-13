package binarysearch.additional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindSmallestAgainTest {

    FindSmallestAgain findSmallestAgain = new FindSmallestAgain();

    @Test
    public void testSampleCases(){
        int[] A = new int[]{2, 4, 3, 2};
        int B = 3;
        assertEquals(9, findSmallestAgain.solve(A, B));

        int[] A2 = new int[]{1, 5, 7, 3, 2};
        int B2 = 9;
        assertEquals(14, findSmallestAgain.solve(A2, B2));
    }

    @Test
    public void testMinimumArraySize() {
        // Test with minimum array size (3 elements)
        int[] A = new int[]{1, 2, 3};
        assertEquals(6, findSmallestAgain.solve(A, 1)); // Only one triplet possible
    }

    @Test
    public void testDuplicateElements() {
        // Test with duplicate elements
        int[] A = new int[]{2, 2, 2, 2};
        assertEquals(findSmallestAgain.bruteForce(A, 1), findSmallestAgain.solve(A, 1)); // All triplets sum to 6
        assertEquals(findSmallestAgain.bruteForce(A, 4), findSmallestAgain.solve(A, 4)); // All triplets sum to 6
    }

    @Test
    public void testAscendingOrder() {
        // Test with strictly ascending array
        int[] A = new int[]{1, 2, 3, 4, 5};
        assertEquals(findSmallestAgain.bruteForce(A, 1), findSmallestAgain.solve(A, 1));  // 1+2+3 = 6
        assertEquals(findSmallestAgain.bruteForce(A, 2), findSmallestAgain.solve(A, 2));  // 1+2+4 = 7
        assertEquals(findSmallestAgain.bruteForce(A, 3), findSmallestAgain.solve(A, 3));  // 1+2+5 = 8
    }

    @Test
    public void testDescendingOrder() {
        // Test with strictly descending array
        int[] A = new int[]{5, 4, 3, 2, 1};
        assertEquals(findSmallestAgain.bruteForce(A, 1), findSmallestAgain.solve(A, 1));  // 1+2+3 = 6
        assertEquals(findSmallestAgain.bruteForce(A, 2), findSmallestAgain.solve(A, 2));  // 1+2+4 = 7
        assertEquals(findSmallestAgain.bruteForce(A, 3), findSmallestAgain.solve(A, 3));  // 1+2+5 = 8
    }

    @Test
    public void testLargeNumbers() {
        // Test with large numbers (close to constraint 10^8)
        int[] A = new int[]{100000000, 99999999, 99999998, 99999997};
        assertEquals(findSmallestAgain.bruteForce(A, 1), findSmallestAgain.solve(A, 1));  // Sum of smallest three
        assertEquals(findSmallestAgain.bruteForce(A, 2), findSmallestAgain.solve(A, 2));  // Sum of next three
    }

    @Test
    public void testMixedNumbers() {
        // Test with mix of small and large numbers
        int[] A = new int[]{1, 100000000, 2, 99999999, 3};
        assertEquals(findSmallestAgain.bruteForce(A, 1), findSmallestAgain.solve(A, 1));  // 1+2+3 = 6
        assertEquals(findSmallestAgain.bruteForce(A, 4), findSmallestAgain.solve(A, 4));  // 1+2+100000000
    }

    @Test
    public void testLastPossibleTriplet() {
        // Test finding the last possible triplet (B = nC3)
        int[] A = new int[]{1, 2, 3, 4, 5};
        int n = A.length;
        int totalTriplets = (n * (n-1) * (n-2)) / 6;
        assertEquals(12, findSmallestAgain.solve(A, totalTriplets));  // 3+4+5 = 12
    }
}
