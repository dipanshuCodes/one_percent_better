package binarysearch.additional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumStaircaseHeightTest {
    MaximumStaircaseHeight staircaseHeight = new MaximumStaircaseHeight();

    @Test
    public void testSampleCase(){
        assertEquals(4, staircaseHeight.solve(10));
        assertEquals(5, staircaseHeight.solve(20));
    }

    @Test
    public void testEdgeCases() {
        // Test edge cases
        assertEquals(0, staircaseHeight.solve(0));    // No blocks
        assertEquals(1, staircaseHeight.solve(1));    // One block
        assertEquals(1, staircaseHeight.solve(2));    // Two blocks
        assertEquals(2, staircaseHeight.solve(3));    // Three blocks
        assertEquals(2, staircaseHeight.solve(4));    // Four blocks
        assertEquals(3, staircaseHeight.solve(6));    // Six blocks
    }

    @Test
    public void testPerfectStaircases() {
        // Test cases where blocks form perfect staircases
        assertEquals(1, staircaseHeight.solve(1));    // 1 block = 1 stair
        assertEquals(2, staircaseHeight.solve(3));    // 1 + 2 = 3 blocks
        assertEquals(3, staircaseHeight.solve(6));    // 1 + 2 + 3 = 6 blocks
        assertEquals(4, staircaseHeight.solve(10));   // 1 + 2 + 3 + 4 = 10 blocks
        assertEquals(5, staircaseHeight.solve(15));   // 1 + 2 + 3 + 4 + 5 = 15 blocks
    }

    @Test
    public void testNonPerfectStaircases() {
        // Test cases where blocks don't form perfect staircases
        assertEquals(1, staircaseHeight.solve(2));    // 1 block used, 1 block left
        assertEquals(2, staircaseHeight.solve(4));    // 1 + 2 = 3 blocks used, 1 block left
        assertEquals(3, staircaseHeight.solve(7));    // 1 + 2 + 3 = 6 blocks used, 1 block left
        assertEquals(4, staircaseHeight.solve(11));   // 1 + 2 + 3 + 4 = 10 blocks used, 1 block left
        assertEquals(5, staircaseHeight.solve(16));   // 1 + 2 + 3 + 4 + 5 = 15 blocks used, 1 block left
    }

    @Test
    public void testLargeNumbers() {
        // Test large numbers
        assertEquals(44720, staircaseHeight.solve(1000000000));  // At 10^9
        assertEquals(44720, staircaseHeight.solve(999999999));   // Just under 10^9
        assertEquals(44720, staircaseHeight.solve(999999000));   // Near 10^9
    }

    @Test
    public void testMediumNumbers() {
        // Test medium-sized numbers
        assertEquals(100, staircaseHeight.solve(5050));      // 1 to 100 = 5050 blocks
        assertEquals(1000, staircaseHeight.solve(500500));   // 1 to 1000 = 500500 blocks
        assertEquals(10000, staircaseHeight.solve(50005000)); // 1 to 10000 = 50005000 blocks
    }

    @Test
    public void testNumbersNearPerfectStaircases() {
        // Test numbers just above and below perfect staircases
        assertEquals(3, staircaseHeight.solve(6));    // Perfect: 1 + 2 + 3 = 6
        assertEquals(3, staircaseHeight.solve(7));    // Just above: 1 + 2 + 3 + 1 = 7
        assertEquals(3, staircaseHeight.solve(8));    // Just above: 1 + 2 + 3 + 2 = 8
        assertEquals(3, staircaseHeight.solve(9));    // Just above: 1 + 2 + 3 + 3 = 9
        assertEquals(4, staircaseHeight.solve(10));   // Perfect: 1 + 2 + 3 + 4 = 10
    }

    @Test
    public void testPowersOfTwo() {
        // Test powers of 2
        assertEquals(1, staircaseHeight.solve(2));    // 2^1
        assertEquals(2, staircaseHeight.solve(4));    // 2^2
        assertEquals(3, staircaseHeight.solve(8));    // 2^3
        assertEquals(5, staircaseHeight.solve(16));   // 2^4 (1+2+3+4+5=15 blocks used)
        assertEquals(7, staircaseHeight.solve(32));   // 2^5 (1+2+3+4+5+6+7=28 blocks used)
    }
}
