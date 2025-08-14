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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==q) return true;
        if(p==null || q==null) return false;

        boolean leftSubTree =  isSameTree(p.left, q.left);
        if(leftSubTree==false) return false;
        boolean rightSubTree =  isSameTree(p.right, q.right);
        return leftSubTree && rightSubTree && (p.val == q.val);
    }
}