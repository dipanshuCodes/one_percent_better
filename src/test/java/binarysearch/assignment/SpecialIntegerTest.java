package binarysearch.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialIntegerTest {

    SpecialInteger specialInteger = new SpecialInteger();

    @Test
    public void testExamplesCase() {
        assertEquals(2, specialInteger.solve(new int[]{1, 2, 3, 4, 5}, 10));
        assertEquals(3, specialInteger.solve(new int[]{5, 17, 100, 11}, 130));
    }

    @Test
    public void testSampleCases() {
        // Test case 1: Basic case with small array
        assertEquals(2, specialInteger.solve(new int[]{1, 2, 3, 4, 5}, 10));
        // Test case 2: All elements are equal
        assertEquals(3, specialInteger.solve(new int[]{2, 2, 2, 2, 2}, 6));
    }

    @Test
    public void testEdgeCases() {
        // Test case 1: Single element array
        assertEquals(1, specialInteger.solve(new int[]{5}, 5));
        assertEquals(0, specialInteger.solve(new int[]{6}, 5));
        
        // Test case 2: Empty array
        assertEquals(0, specialInteger.solve(new int[]{}, 10));
    }

    @Test
    public void testLargeNumbers() {
        // Test case 1: Large numbers with small B
        assertEquals(0, specialInteger.solve(new int[]{1000000000, 1000000000}, 999999999));
        
        // Test case 2: Large numbers with large B
        assertEquals(2, specialInteger.solve(new int[]{1000000000, 1000000000}, 2000000000));
    }

    @Test
    public void testIncreasingSequence() {
        // Test case 1: Strictly increasing sequence
        assertEquals(0, specialInteger.solve(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 6));
        
        // Test case 2: Increasing sequence with large jumps
        assertEquals(0, specialInteger.solve(new int[]{1, 10, 100, 1000, 10000}, 50));
    }

    @Test
    public void testDecreasingSequence() {
        // Test case 1: Strictly decreasing sequence
        assertEquals(2, specialInteger.solve(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 25));
        
        // Test case 2: Decreasing sequence with large jumps
        assertEquals(0, specialInteger.solve(new int[]{10000, 1000, 100, 10, 1}, 50));
    }

    @Test
    public void testMixedValues() {
        // Test case 1: Mixed positive values
        assertEquals(4, specialInteger.solve(new int[]{5, 1, 2, 10, 3, 4, 1}, 20));
        
        // Test case 2: Mixed values with some large numbers
        assertEquals(0, specialInteger.solve(new int[]{1, 1000, 2, 3, 4, 5, 1000}, 10));
    }

    @Test
    public void testMaximumConstraints() {
        // Test case 1: Maximum array size with small values
        int[] largeArray = new int[100000];
        for (int i = 0; i < 100000; i++) {
            largeArray[i] = 1;
        }
        assertEquals(100000, specialInteger.solve(largeArray, 100000));
        
        // Test case 2: Maximum array size with large values
        for (int i = 0; i < 100000; i++) {
            largeArray[i] = 1000000000;
        }
        assertEquals(1, specialInteger.solve(largeArray, 1000000000));
    }

    @Test
    public void testAlternatingValues() {
        // Test case 1: Alternating small and large values
        assertEquals(2, specialInteger.solve(new int[]{1, 100, 1, 100, 1, 100}, 101));
        
        // Test case 2: Alternating values with different patterns
        assertEquals(2, specialInteger.solve(new int[]{1, 10, 1, 10, 1, 10}, 12));
    }

    @Test
    public void testSubarraySumBoundary() {
        // Test case 1: Subarray sum exactly equals B
        assertEquals(1, specialInteger.solve(new int[]{1, 2, 3, 4, 5}, 6));
        
        // Test case 2: Multiple subarrays with sum equal to B
        assertEquals(2, specialInteger.solve(new int[]{3, 3, 3, 3, 3}, 6));
    }

    @Test
    public void testRandomPatterns() {
        // Test case 1: Random pattern with varying sums
        // No subarray of size 2 has sum > 6 (some equal to 6 which is allowed)
        // Some subarrays of size 3 have sum > 6 (e.g., {3,1,4} = 8)
        assertEquals(2, specialInteger.solve(new int[]{2, 3, 1, 4, 2, 1, 3}, 6));
        
        // Test case 2: Random pattern with larger numbers
        // Some subarrays of size 2 have sum > 10 (e.g., {3,8} = 11, {7,4} = 11)
        assertEquals(1, specialInteger.solve(new int[]{5, 3, 8, 2, 7, 4, 6}, 10));
    }
}
