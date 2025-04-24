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
    public int kthSmallest(TreeNode root, int k) {
        return helper(root,new int[]{k});
    }

    private int helper(TreeNode root, int[] kth){
        if(root==null) return -1;
       
        int l = helper(root.left, kth);
        if(l != -1) return l;
        kth[0]--;
        if(kth[0]==0) return root.val;
        int r = helper(root.right, kth);
        if(r != -1) return r;
        return -1;
    }
}