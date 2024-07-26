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
    public boolean checkTree(TreeNode root) {
        int ans = helper(root);
        return ans != Integer.MIN_VALUE ? true : false;
    }

    public int helper(TreeNode root){
         if(root.left == null && root.right==null) return root.val;
        
        int left=0,right=0;
        if(root.left != null)
            left = helper(root.left);
        if(root.right != null)
            right = helper(root.right);
        
        if(left == Integer.MIN_VALUE || right == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        
        int sum=0;
        sum+=left+right;
        
        if(sum != root.val)
            return Integer.MIN_VALUE;
        return sum;
    }
}