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
     
        boolean left = false;
        boolean right = false;
        if(p.val < root.val && q.val < root.val)
            left = helper(root.left, p,q);
        
        if(root.val<p.val && root.val<q.val)
            right = helper(root.right, p,q);

        if(!left && !right){
            lca=root;
            return true;
        }

        return left || right;
    }
}