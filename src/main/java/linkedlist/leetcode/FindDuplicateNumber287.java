package linkedlist.leetcode;

public class FindDuplicateNumber287 {
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        while(slow<n){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(nums[slow]==nums[fast]) break;
        }

        slow = 0;
        while(nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];


    }

}
