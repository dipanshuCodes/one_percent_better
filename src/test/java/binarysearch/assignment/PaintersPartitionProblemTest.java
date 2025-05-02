package binarysearch.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaintersPartitionProblemTest {
    PaintersPartitionProblem problem = new PaintersPartitionProblem();

    @Test
    public void testSampleCases(){
        assertEquals(50, problem.paint(2, 5, new int[]{1, 10}));
        assertEquals(11, problem.paint(10, 1, new int[]{1, 8, 11, 3}));
    }

    @Test
    public void testLargeInputCases(){
        assertEquals(9400003, problem.paint(1, 1000000, new int[]{1000000,1000000}));
    }
    @Test
    void testLargeNumberOfBoards() {
        PaintersPartitionProblem problem = new PaintersPartitionProblem();

        int A = 2; // Number of painters
        int B = 1; // Time per unit of painting
        int[] C = {10, 20, 30, 100, 200, 300}; // Large boards

        int expected = 360; // Optimal division: (300+60) OR similar combinations
        assertEquals(expected, problem.paint(A, B, C));
    }

    @Test
    void testEdgeCaseEmptyArray() {
        PaintersPartitionProblem problem = new PaintersPartitionProblem();

        int A = 3; // Number of painters
        int B = 10; // Time per unit of painting
        int[] C = {}; // No boards

        int expected = 0; // No boards to paint
        assertEquals(expected, problem.paint(A, B, C));
    }
}
