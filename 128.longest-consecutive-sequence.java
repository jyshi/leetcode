/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int max = 1;
        int curr = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            //注意可能出现重复的情况
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                curr++;
                max = Math.max(max, curr);
            } else {
                curr = 1;
            }
        }
        // max = Math.max(max, curr);
        return max;
    }
}
// @lc code=end

// 100  4  200  1   3   2
// 0    1    2   3   4   5