package binarysearch.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AggressiveCowsTest {

    AggressiveCows aggressiveCows = new AggressiveCows();

    @Test
    public void testSampleCase() {
        assertEquals(2, aggressiveCows.solve(new int[]{1, 2, 3, 4, 5}, 3));
        assertEquals(1, aggressiveCows.solve(new int[]{1, 2}, 2));
    }

    @Test
    public void testLargeInput() {
        // Test with maximum constraints
        int[] largeStalls = new int[100000];
        for (int i = 0; i < 100000; i++) {
            largeStalls[i] = i * 1000;
        }
        assertEquals(99999000, aggressiveCows.solve(largeStalls, 2));
    }

    @Test
    public void testUnevenlySpacedStalls() {
        assertEquals(6, aggressiveCows.solve(new int[]{1, 4, 7, 10, 13}, 3));
        assertEquals(12, aggressiveCows.solve(new int[]{1, 7, 13, 19, 25}, 3));
    }

    @Test
    public void testMinimumCows() {
        // Test with minimum number of cows (2)
        assertEquals(12, aggressiveCows.solve(new int[]{1, 5, 9, 13}, 2));
        assertEquals(27, aggressiveCows.solve(new int[]{1, 10, 19, 28}, 2));
    }

    @Test
    public void testMaximumCows() {
        // Test with maximum number of cows (equal to number of stalls)
        assertEquals(1, aggressiveCows.solve(new int[]{1, 2, 3, 4, 5}, 5));
        assertEquals(1, aggressiveCows.solve(new int[]{10, 11, 12, 13}, 4));
    }

    @Test
    public void testSinglePossibleSolution() {
        // Test cases where there's only one possible solution
        assertEquals(6, aggressiveCows.solve(new int[]{1, 3, 5, 7}, 2));
        assertEquals(9, aggressiveCows.solve(new int[]{1, 4, 7, 10}, 2));
    }

    @Test
    public void testLargeGaps() {
        // Test with large gaps between stalls
        assertEquals(300, aggressiveCows.solve(new int[]{1, 101, 201, 301}, 2));
        assertEquals(100, aggressiveCows.solve(new int[]{1, 51, 101, 151, 201}, 3));
    }
}
