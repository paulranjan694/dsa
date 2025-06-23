/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSoFar = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSoFar;
    }
    public int maxPathSumHelper(TreeNode root) {
        if(root == null) return 0;
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        int pathSumToConsider = Math.max(root.val+Math.max(left,right),root.val);
        maxSoFar = Math.max(maxSoFar, Math.max(root.val+left+right, pathSumToConsider));
        return pathSumToConsider;
    }
}