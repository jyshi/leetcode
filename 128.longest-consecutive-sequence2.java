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
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int max = 1;
        for (int n : nums) {
            // 关键！
            if (!set.contains(n - 1)) {
                int curr = 1;
                int next = n + 1;
                while (set.contains(next++)) {
                    curr++;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}
// @lc code=end

// 100  4  200  1   3   2
// 0    1    2   3   4   5