/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    String[] map = new String[10];


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        init();
        backTrack(digits, 0, result, "");
        return result;

    }
    private void init() {
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
    }
    private void backTrack(String digits, int index, List<String> result, String prev) {
        if (digits.length() == index) {
            result.add(prev);
            return;
        }
        
        String value = map[digits.charAt(index) - '0'];
        for (char c: value.toCharArray()) {
            String curr = new String(prev);
            curr += c;
            backTrack(digits, index + 1, result, curr);
        }

    }
}
// @lc code=end

// a        b         c              index = 0
// d e f   d e f     d e f           index = 1