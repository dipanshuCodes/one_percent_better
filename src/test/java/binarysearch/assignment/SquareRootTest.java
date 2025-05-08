package binarysearch.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareRootTest {

    public SquareRoot squareRoot = new SquareRoot();

    @Test
    public void testSampleCase(){
        assertEquals(3, squareRoot.sqrt(11));
        assertEquals(3, squareRoot.sqrt(9));
    }

    @Test
    public void testEdgeCases() {
        // Test edge cases
        assertEquals(0, squareRoot.sqrt(0));      // Zero
        assertEquals(1, squareRoot.sqrt(1));      // One
        assertEquals(1, squareRoot.sqrt(2));      // Two
        assertEquals(1, squareRoot.sqrt(3));      // Three
        assertEquals(2, squareRoot.sqrt(4));      // Perfect square
    }

    @Test
    public void testPerfectSquares() {
        // Test perfect squares
        assertEquals(2, squareRoot.sqrt(4));      // 2^2
        assertEquals(3, squareRoot.sqrt(9));      // 3^2
        assertEquals(4, squareRoot.sqrt(16));     // 4^2
        assertEquals(5, squareRoot.sqrt(25));     // 5^2
        assertEquals(10, squareRoot.sqrt(100));   // 10^2
        assertEquals(100, squareRoot.sqrt(10000)); // 100^2
    }

    @Test
    public void testNonPerfectSquares() {
        // Test non-perfect squares
        assertEquals(2, squareRoot.sqrt(5));      // Between 2^2 and 3^2
        assertEquals(3, squareRoot.sqrt(10));     // Between 3^2 and 4^2
        assertEquals(4, squareRoot.sqrt(17));     // Between 4^2 and 5^2
        assertEquals(5, squareRoot.sqrt(26));     // Between 5^2 and 6^2
        assertEquals(9, squareRoot.sqrt(99));     // Between 9^2 and 10^2
    }

    @Test
    public void testLargeNumbers() {
        // Test large numbers
        assertEquals(31622, squareRoot.sqrt(999999999));  // Near 10^9
        assertEquals(31622, squareRoot.sqrt(1000000000)); // 10^9
        assertEquals(31622, squareRoot.sqrt(1000000001)); // Just over 10^9
    }

    @Test
    public void testMediumNumbers() {
        // Test medium-sized numbers
        assertEquals(100, squareRoot.sqrt(10000));    // 100^2
        assertEquals(1000, squareRoot.sqrt(1000000)); // 1000^2
        assertEquals(3162, squareRoot.sqrt(10000000)); // ~3162^2
    }

    @Test
    public void testNumbersNearPerfectSquares() {
        // Test numbers just above and below perfect squares
        assertEquals(2, squareRoot.sqrt(4));      // 2^2
        assertEquals(2, squareRoot.sqrt(5));      // Just above 2^2
        assertEquals(2, squareRoot.sqrt(6));      // Just above 2^2
        assertEquals(2, squareRoot.sqrt(7));      // Just above 2^2
        assertEquals(2, squareRoot.sqrt(8));      // Just above 2^2
        assertEquals(3, squareRoot.sqrt(9));      // 3^2
    }

    @Test
    public void testPowersOfTwo() {
        // Test powers of 2
        assertEquals(2, squareRoot.sqrt(4));      // 2^2
        assertEquals(4, squareRoot.sqrt(16));     // 4^2
        assertEquals(8, squareRoot.sqrt(64));     // 8^2
        assertEquals(16, squareRoot.sqrt(256));   // 16^2
        assertEquals(32, squareRoot.sqrt(1024));  // 32^2
    }
}
