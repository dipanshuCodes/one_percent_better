package binarysearch.additional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllocatedBooksTest {
    AllocateBooks allocateBooks = new AllocateBooks();

    @Test
    public void testSampleCase(){
        assertEquals(113, allocateBooks.books(new int[]{12, 34, 67, 90}, 2));
        assertEquals(-1, allocateBooks.books(new int[]{12, 15, 78}, 4));
    }

    @Test
    public void testSingleStudent() {
        // When there's only one student, they must read all books
        // Result should be sum of all pages
        assertEquals(15, allocateBooks.books(new int[]{5, 3, 7}, 1));
        assertEquals(100, allocateBooks.books(new int[]{10, 20, 30, 40}, 1));
    }

    @Test
    public void testStudentsEqualToBooks() {
        // When number of students equals number of books
        // Result should be maximum pages in any book
        assertEquals(7, allocateBooks.books(new int[]{3, 7, 4}, 3));
        assertEquals(40, allocateBooks.books(new int[]{10, 20, 30, 40}, 4));
    }

    @Test
    public void testEqualPageBooks() {
        // When all books have equal pages
        assertEquals(20, allocateBooks.books(new int[]{10, 10, 10, 10}, 2)); // 2 students get 20 pages each
        assertEquals(90, allocateBooks.books(new int[]{30, 30, 30}, 1));     // 1 student gets all 90 pages
    }

    @Test
    public void testLargeVariation() {
        // Books with large variation in pages
        // With contiguous allocation, minimum possible maximum is 101
        // Distribution: [1,2,98], [99], [100]
        assertEquals(101, allocateBooks.books(new int[]{1, 2, 98, 99, 100}, 3));
        // Distribution: [1,2,3,1000], [1000] - minimum possible maximum is 1006
        assertEquals(1006, allocateBooks.books(new int[]{1, 2, 3, 1000, 1000}, 2));
    }

    @Test
    public void testMinimumStudents() {
        // Edge cases with minimum number of students
        assertEquals(3, allocateBooks.books(new int[]{1, 2, 3}, 2));
        assertEquals(5, allocateBooks.books(new int[]{1, 1, 1, 1, 5}, 3));
    }

    @Test
    public void testImpossibleAllocation() {
        // Cases where allocation is impossible
        assertEquals(-1, allocateBooks.books(new int[]{1, 2}, 3));           // More students than books
        assertEquals(-1, allocateBooks.books(new int[]{10, 20, 30}, 4));     // More students than books
        assertEquals(-1, allocateBooks.books(new int[]{}, 1));               // Empty array
    }

    @Test
    public void testConsecutivePages() {
        // Books with consecutive page numbers
        assertEquals(17, allocateBooks.books(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3));  // Should split into 3 parts
        assertEquals(9, allocateBooks.books(new int[]{1, 2, 3, 4, 5, 6}, 3));            // Distribution: [1,2,3], [4,5], [6]
    }

    @Test
    public void testLargeInput() {
        // Test with larger numbers within constraints
        int[] largeArray = new int[1000];
        for(int i = 0; i < 1000; i++) {
            largeArray[i] = 1000;
        }
        assertEquals(100000, allocateBooks.books(largeArray, 10)); // Each student gets 100 books of 1000 pages
    }
}
