package linkedlist.leetcode;

import interview.AmazonOA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class problem287Findduplicatenumbertest {
    @Test
    public void should_return_2() {
        int[] arr = new int[]{ 4, 2, 1, 3, 2};
        assertEquals(2, FindDuplicateNumber287.findDuplicate(arr));
    }

    @Test
    public void should_return_1() {
        int[] arr = new int[]{ 1, 1};
        assertEquals(1, FindDuplicateNumber287.findDuplicate(arr));
    }

    @Test
    public void should_return_3() {
        int[] arr = new int[]{3, 1, 3, 4, 2};
        assertEquals(3, FindDuplicateNumber287.findDuplicate(arr));
    }

    @Test
    public void oa_should_return_2() {
        int[] arr = new int[] {1, 8, 5, 9, 8, 8, 7, 7, 5, 7, 7};
        assertEquals(2, AmazonOA.countElements(arr));
    }

}
