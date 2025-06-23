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
        if(root == null) return Integer.MIN_VALUE;
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        maxSoFar = Math.max(maxSoFar, Math.max(root.val+Math.max(left,0)+Math.max(right,0), root.val+Math.max(Math.max(left,right),0)));
        return root.val + Math.max(0,Math.max(left,right));
    }
}