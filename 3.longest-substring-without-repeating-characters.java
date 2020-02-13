/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } 
        int[] map = new int[256];
        int maxLen = 1;
        int left = 0, right = 0;
        while (right < s.length()) {
            if (map[s.charAt(right)] == 0) {
                maxLen = Math.max(maxLen, right - left + 1);
                map[s.charAt(right++)]++;
            } else {
                map[s.charAt(left++)]--;
            }
        }
        return maxLen;
    }
}
// @lc code=end




