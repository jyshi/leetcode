/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j] means whether first i char of s match first j char of p
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // dp[i][0] = false
        // a* or a*a* ...
        for (int i = 2; i <= n; i+=2) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    // zero matches
                    dp[i][j] = dp[i][j - 2];
                    // more matches
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];


    }
}
// @lc code=end

