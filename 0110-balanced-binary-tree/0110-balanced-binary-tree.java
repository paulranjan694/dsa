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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int left = isBalancedHeight(root.left);
        if(left == Integer.MAX_VALUE) return false;
        int right = isBalancedHeight(root.right);
        if(right == Integer.MAX_VALUE) return false;


        return Math.abs(left-right) <= 1;
    }

    private int isBalancedHeight(TreeNode root){
        if(root == null) return 0;
        int left = isBalancedHeight(root.left);
        if(left == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        int right = isBalancedHeight(root.right);
        if(left == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(Math.abs(left-right) > 1) return Integer.MAX_VALUE;
        return 1 + Math.max(left,right);
    }
}