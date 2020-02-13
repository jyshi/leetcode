/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    Map<Character, Character> map = new HashMap<>();
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (map.keySet().contains(c)) {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                } 
                if (map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
// @lc code=end

