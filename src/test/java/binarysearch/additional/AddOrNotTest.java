package binarysearch.additional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AddOrNotTest {

    AddOrNot addOrNot = new AddOrNot();

    @Test
    public void testSampleCase() {
        // First sample case
        int[] A1 = {3, 1, 2, 2, 1};
        int B1 = 3;
        int[] expected1 = {4, 2};
        assertArrayEquals( expected1, addOrNot.solve(A1, B1));

        // Second sample case
        int[] A2 = {5, 5, 5};
        int B2 = 3;
        int[] expected2 = {3, 5};
        assertArrayEquals(expected2, addOrNot.solve(A2, B2));
    }

    @Test
    public void testSampleCase2() {
        int[] A3 = {-5, 6, 1, -5, 1, -3, 1, 3, 1, 5};
        int B3 = 9;
        int[] expected3 = {5, 1};
        assertArrayEquals(expected3, addOrNot.solve(A3, B3));
    }

    @Test
    public void testEdgeCases() {
        // Test with minimum array size (N = 1)
        int[] A1 = {1};
        int B1 = 5;
        assertArrayEquals(addOrNot.bruteForce(A1, B1), addOrNot.solve(A1, B1));

        // Test with B = 0 (no operations allowed)
        int[] A2 = {1, 2, 3, 4, 5};
        int B2 = 0;
        assertArrayEquals(addOrNot.bruteForce(A2, B2), addOrNot.solve(A2, B2));

        // Test with all negative numbers
        int[] A3 = {-5, -3, -1, -2, -4};
        int B3 = 10;
        assertArrayEquals(addOrNot.bruteForce(A3, B3), addOrNot.solve(A3, B3));
    }

    @Test
    public void testLargeNumbers() {
        // Test with numbers near the constraint limits
        int[] A1 = {1_000_000_000, 999_999_999, 999_999_998};
        int B1 = 5;
        assertArrayEquals(addOrNot.bruteForce(A1, B1), addOrNot.solve(A1, B1));

        // Test with large B value
        int[] A2 = {1, 2, 3, 4, 5};
        int B2 = 1_000_000_000;
        assertArrayEquals(addOrNot.bruteForce(A2, B2), addOrNot.solve(A2, B2));
    }

    @Test
    public void testMultipleSameNumbers() {
        // Test with multiple same numbers
        int[] A1 = {1, 1, 1, 1, 1};
        int B1 = 10;
        assertArrayEquals(addOrNot.bruteForce(A1, B1), addOrNot.solve(A1, B1));

        // Test with alternating same numbers
        int[] A2 = {1, 2, 1, 2, 1, 2};
        int B2 = 5;
        assertArrayEquals(addOrNot.bruteForce(A2, B2), addOrNot.solve(A2, B2));
    }

    @Test
    public void testOptimalOperations() {
        // Test where optimal solution requires partial operations
        int[] A1 = {1, 2, 3, 4, 5};
        int B1 = 7;
        assertArrayEquals(addOrNot.bruteForce(A1, B1), addOrNot.solve(A1, B1));

        // Test where we can't make all numbers equal
        int[] A2 = {1, 5, 10, 15, 20};
        int B2 = 8;
        assertArrayEquals(addOrNot.bruteForce(A2, B2), addOrNot.solve(A2, B2));
    }
}
