/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        helper(root, path, result);
        return result;
    }
    private void helper(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null) {
            return;
        }
        int pathLen = path.length();
        path.append(node.val);
        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            helper(node.left, path, result);
            helper(node.right, path, result);
        }
        path.setLength(pathLen);
    }
}
// @lc code=end

