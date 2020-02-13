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
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                // | left consecutive | n | right consecutive |
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                int len = left + right + 1;
                max = Math.max(max, len);
                map.put(n, len);
                map.put(n - left, len);
                map.put(n + right, len);
            }
        }
        return max;
    }
}
// @lc code=end
