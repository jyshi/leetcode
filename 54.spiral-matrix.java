/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int row_begin = 0, row_end = matrix.length - 1;
        int col_begin = 0, col_end = matrix[0].length - 1;
        // needs to check whether row_begin <= row_end && col_begin <= col_end in every direction
        while (row_begin <= row_end && col_begin <= col_end) {
            for (int i = col_begin; row_begin <= row_end && i <= col_end; i++) {
                result.add(matrix[row_begin][i]);
            }
            row_begin++;
            for (int i = row_begin; col_begin <= col_end && i <= row_end; i++) {
                result.add(matrix[i][col_end]);
            }
            col_end--;
            for (int i = col_end; row_begin <= row_end && i >= col_begin; i--) {
                result.add(matrix[row_end][i]);
            }
            row_end--;
            for (int i = row_end; col_begin <= col_end && i >= row_begin; i--) {
                result.add(matrix[i][col_begin]);
            }
            col_begin++;
        }
        return result;
    }
}
// @lc code=end
