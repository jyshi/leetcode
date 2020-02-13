/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String result;
        int n = s.length();
        boolean[][] check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            check[i][i] = true;
        }
        int maxLen = 0;
        String maxStr = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if ((i + 1 >= j - 1 || check[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
                    check[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        maxStr = s.substring(i, j + 1);
                    }
                }
            }
        }
        return maxStr;
    }
}
// @lc code=end
