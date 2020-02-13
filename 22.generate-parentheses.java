/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(n, 0, result, "");
        return result;
    }
    private void backTrack(int n, int leftNum, List<String> result, String prev) {
        if (prev.length() == n * 2) {
            result.add(prev);
        }
        if (leftNum < n) {
            backTrack(n, leftNum + 1, result, prev + '(');
        } 
        if (leftNum > prev.length() - leftNum) {
            backTrack(n, leftNum, result, prev + ')');
        }
    }
}
// @lc code=end

