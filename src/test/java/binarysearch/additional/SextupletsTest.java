package binarysearch.additional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SextupletsTest {

    Sextuplets sut = new Sextuplets();

    @Test
    public void testSampleCase(){
        assertEquals(1, sut.solve(new int[]{1}));
        assertEquals(24, sut.solve(new int[]{1,-1}));
        assertEquals(255, sut.solve(new int[]{1,3,2,-1}));
        assertEquals(1350683, sut.solve(new int[]{13,-25,9,-27,-5,-23,19,1,-21,25,15,-29,-3,21,3,23,-15,-17,-1,0,-19,-11,-9,-7,5,17,-13,11,27,7}));
    }

    @Test
    public void testSmallArrays() {
        // Test with small arrays where we can manually verify results
        assertEquals(0, sut.solve(new int[]{2}));                     // Single element (no valid sextuplets)
        assertEquals(13, sut.solve(new int[]{1, 2}));                // Two elements
        assertEquals(65, sut.solve(new int[]{1, 2, 3}));            // Three elements
        assertEquals(269, sut.solve(new int[]{0, 1, 2, 3}));        // Four elements including zero
    }

    @Test
    public void testSpecialNumbers() {
        // Test with special numbers like 0, 1, -1
        assertEquals(0, sut.solve(new int[]{0}));                    // Single zero (no valid sextuplets)
        assertEquals(12, sut.solve(new int[]{0, 1}));               // Zero and one
        assertEquals(118, sut.solve(new int[]{-1, 0, 1}));          // Negative one, zero, and one
        assertEquals(401, sut.solve(new int[]{-1, 0, 1, 2}));       // Basic number set
    }

    @Test
    public void testNegativeNumbers() {
        // Test with negative numbers
        assertEquals(3, sut.solve(new int[]{-2, -1}));              // All negative
        assertEquals(43, sut.solve(new int[]{-2, -1, 0}));          // Negative and zero
        assertEquals(400, sut.solve(new int[]{-2, -1, 1, 2}));      // Mixed positive and negative
    }

    @Test
    public void testConsecutiveNumbers() {
        // Test with consecutive numbers
        assertEquals(219, sut.solve(new int[]{1, 2, 3, 4}));        // Positive consecutive
        assertEquals(1344, sut.solve(new int[]{-2, -1, 0, 1, 2}));  // Consecutive including zero
        assertEquals(156, sut.solve(new int[]{-3, -2, -1, 0}));     // Negative consecutive with zero
    }

    @Test
    public void testLargeNumbers() {
        // Test with numbers close to constraints
        assertEquals(46, sut.solve(new int[]{1000000, -1000000, 0}));  // Max and min values
        assertEquals(61, sut.solve(new int[]{999999, -999999, 1}));    // Near max/min values
    }

    @Test
    public void testPowerOfTwo() {
        // Test with powers of 2
        assertEquals(190, sut.solve(new int[]{1, 2, 4, 8}));        // Powers of 2
        assertEquals(72, sut.solve(new int[]{-8, -4, -2, -1}));     // Negative powers of 2
        assertEquals(902, sut.solve(new int[]{-2, -1, 1, 2, 4}));   // Mixed powers of 2
    }

    @Test
    public void testDivisibleNumbers() {
        // Test with numbers that are divisible by each other
        assertEquals(98, sut.solve(new int[]{2, 4, 6, 8}));         // Even numbers
        assertEquals(37, sut.solve(new int[]{3, 6, 9, 12}));        // Multiples of 3
        assertEquals(0, sut.solve(new int[]{5, 10, 15, 20}));       // Multiples of 5
    }
}
