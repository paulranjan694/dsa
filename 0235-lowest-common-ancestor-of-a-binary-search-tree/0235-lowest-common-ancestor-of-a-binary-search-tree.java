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
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return lca;
    }

    public boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        if(root == p || root == q){
            lca=root;
            return true;
        }
        
        boolean left = helper(root.left, p,q);
        boolean right = helper(root.right, p,q);

        if(left && right){
            lca=root;
        }

        return left || right;
    }
}