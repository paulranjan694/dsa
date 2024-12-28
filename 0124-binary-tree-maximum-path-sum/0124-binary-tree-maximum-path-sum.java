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
    private int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        height(root);
        return maxsum;
    }

    private int height(TreeNode root){
        if(root==null) return 0;
        int ls = height(root.left);
        ls = Math.max(0,ls);
        int rs = height(root.right);
        rs = Math.max(0,rs);

        maxsum=Math.max(maxsum,ls+rs+root.val);

        return Math.max(ls,rs)+root.val;
    }
}