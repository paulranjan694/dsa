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
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.left,root.right);
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }

        if(left.val != right.val) return false;

        boolean l = checkSymmetric(left.left,right.right);
        if(l==false) return false;
        boolean r = checkSymmetric(left.right,right.left);
        if(r==false) return false;
        return l && r;
    }
}