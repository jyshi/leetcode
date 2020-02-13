/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows == 1) {
            return s;
        }
        int n = s.length();
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int row = 0;
        for (int i = 0; i < n; i++) {
            (rows[row]).append(s.charAt(i));
            // 2 * numRows - 2 could be 0 !
            if (i % (2 * numRows - 2) < numRows - 1) {
                row++;
            } else {
                row--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(rows[i]);
        }
        return result.toString();
    }
}
// @lc code=end
