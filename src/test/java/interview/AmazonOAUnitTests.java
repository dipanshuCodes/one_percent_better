package interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmazonOAUnitTests {

    @Test
    public void A_countElements() {
        // Test Case 1: Normal case
        assertEquals(3, AmazonOA.countElements(new int[]{1, 2, 2, 3, 3, 3}));

        // Test Case 2: All unique
        assertEquals(4, AmazonOA.countElements(new int[]{1, 2, 3, 4, 5}));

        // Test Case 3: All same
        assertEquals(0, AmazonOA.countElements(new int[]{7, 7, 7, 7}));

        // Test Case 4: Same max frequency
        assertEquals(3, AmazonOA.countElements(new int[]{1, 1, 2, 2, 3}));

        // Test Case 5: Empty array
        assertEquals(0, AmazonOA.countElements(new int[]{}));

        // Test Case 6: Negative numbers
        assertEquals(2, AmazonOA.countElements(new int[]{-1, -1, -2, -3, -1}));

        // Test Case 7: Large numbers
        assertEquals(1, AmazonOA.countElements(new int[]{1000000, 1000000, 999999}));
    }
}
