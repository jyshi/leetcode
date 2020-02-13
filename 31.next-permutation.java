/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int j = n - 1;
        if (i >= 0) {
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

    private void reverse(int[] nums, int i) {
       int j = nums.length - 1;
       while (i < j) {
           swap(nums, i++, j--);
       }
    }
}
// @lc code=end

// 1 4 5 3 2 -> 2 1 3 5
// 1 3 5 2 -> 1 5 2 3
