/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int n = digits.length;
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] += carry + 1;
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] = 0;
                carry = 1;
            }
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        for (int i = 0; i < n; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
}
// @lc code=end

