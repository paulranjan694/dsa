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
    public TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return ans;
    }

    public boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;

        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);

        if(root == p || root == q){
            ans = root;
            return true;
        }

        if(left && right){
            ans = root;
        }
        return left || right;
    }
}