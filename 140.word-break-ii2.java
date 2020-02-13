 /*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new LinkedList<>();
        }
        int n = s.length();
        List<String>[] dp = new LinkedList[n + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = 0; i <= n; i++) {
            dp[i] = new LinkedList<>();
        }
        if (!check(s, wordDict)) {
            return dp[n];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (wordSet.contains(s.substring(j, i))) {
                    String subStr = s.substring(j, i);
                    if (j == 0) {
                        dp[i].add(subStr);
                    } else if (dp[j].size() > 0) {
                        for (String str : dp[j]) {
                            dp[i].add(str + " " + subStr);
                        }
                    }
                }
            }
        }

        return dp[n];
    }
    public boolean check(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
// @lc code=end

