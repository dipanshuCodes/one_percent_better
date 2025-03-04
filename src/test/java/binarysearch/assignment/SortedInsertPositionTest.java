package binarysearch.assignment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortedInsertPositionTest {
    @Test
    public void should_returnIndex() {
        int[] arr = new int[]{ 1, 4, 5, 7 };
        assertEquals(2, SortedInsertPosition.searchInsert(arr, 5));
    }

    @Test
    public void should_returnIndexOfLeastElementGreaterEqualToTarget() {
        int[] arr = new int[]{ 1, 4, 5, 7 };
        assertEquals(3, SortedInsertPosition.searchInsert(arr, 6));
    }
}
