package binarysearch.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotatedArraySearchTest {

    RotatedSortedArraySearch arraySearch = new RotatedSortedArraySearch();
    
    @Test
    public void testSampleCase() {
        assertEquals(0,arraySearch.search(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 4));
        assertEquals(3, arraySearch.search(new int[]{9, 10, 3, 5, 6, 8}, 5));
    }

    @Test
    public void testElementNotFound() {
        // Test case where element is not present in array
        assertEquals(-1, arraySearch.search(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 8));
        assertEquals(-1, arraySearch.search(new int[]{9, 10, 3, 5, 6, 8}, 7));
    }

    @Test
    public void testSingleElementArray() {
        // Test with single element array
        assertEquals(0, arraySearch.search(new int[]{1}, 1));
        assertEquals(-1, arraySearch.search(new int[]{1}, 2));
    }

    @Test
    public void testFullyRotatedArray() {
        // Test with array rotated by its full length
        assertEquals(0, arraySearch.search(new int[]{1, 2, 3, 4, 5}, 1));
        assertEquals(4, arraySearch.search(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    public void testPartiallyRotatedArray() {
        // Test with array rotated by different positions
        assertEquals(2, arraySearch.search(new int[]{3, 4, 5, 1, 2}, 5));
        assertEquals(4, arraySearch.search(new int[]{3, 4, 5, 1, 2}, 2));
    }

    @Test
    public void testLargeNumbers() {
        // Test with large numbers
        assertEquals(2, arraySearch.search(new int[]{1000000, 2000000, 3000000, 4000000, 5000000}, 3000000));
        assertEquals(-1, arraySearch.search(new int[]{1000000, 2000000, 3000000, 4000000, 5000000}, 6000000));
    }

    @Test
    public void testEdgeCases() {
        // Test with empty array
        assertEquals(-1, arraySearch.search(new int[]{}, 1));
        
        // Test with array of size 2
        assertEquals(0, arraySearch.search(new int[]{2, 1}, 2));
        assertEquals(1, arraySearch.search(new int[]{2, 1}, 1));
    }

    @Test
    public void testRotatedAtDifferentPositions() {
        // Original array: [1, 2, 3, 4, 5, 6, 7, 8]
        
        // Rotated by 1 position: [8, 1, 2, 3, 4, 5, 6, 7]
        assertEquals(1, arraySearch.search(new int[]{8, 1, 2, 3, 4, 5, 6, 7}, 1));
        
        // Rotated by 3 positions: [6, 7, 8, 1, 2, 3, 4, 5]
        assertEquals(3, arraySearch.search(new int[]{6, 7, 8, 1, 2, 3, 4, 5}, 1));
        
        // Rotated by 6 positions: [3, 4, 5, 6, 7, 8, 1, 2]
        assertEquals(6, arraySearch.search(new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 1));
        
        // Test searching for elements at different positions in each rotation
        assertEquals(7, arraySearch.search(new int[]{8, 1, 2, 3, 4, 5, 6, 7}, 7)); // Rotated by 1
        assertEquals(2, arraySearch.search(new int[]{6, 7, 8, 1, 2, 3, 4, 5}, 8)); // Rotated by 3
        assertEquals(0, arraySearch.search(new int[]{3, 4, 5, 6, 7, 8, 1, 2}, 3)); // Rotated by 6
    }
}
