/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int sum = 0;
        int left_max = height[0], right_max = height[height.length - 1];
        int i = 1, j = height.length - 2;
        while (i <= j) {
            if (left_max < right_max) {
                left_max = Math.max(left_max, height[i]);
                sum += left_max - height[i++];
            } else {
                right_max = Math.max(right_max, height[j]);
                sum += right_max - height[j--];                
            }
        }
        return sum;
    }
}
// @lc code=end
// [0,1,0,2,1,0,1,3,2,1,2,1]
//    i
//                      j
// left_max = 0
// right_max = 1