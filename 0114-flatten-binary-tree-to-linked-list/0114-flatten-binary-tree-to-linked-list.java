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
    public void flatten(TreeNode root) {
        utils(root);
    }

    private TreeNode utils(TreeNode root){
        if(root == null) return null;
        TreeNode left = utils(root.left);
        TreeNode right = utils(root.right);
        if(left != null){
            root.right=left;
            root.left = null;
            while(left.right != null){
                left = left.right;
            }
            left.right = right;
        }
        return root;
    }
}