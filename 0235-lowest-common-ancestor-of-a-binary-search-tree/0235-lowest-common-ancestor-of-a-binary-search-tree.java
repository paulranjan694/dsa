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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        TreeNode ans = null;
        while(root != null){
            if(p.val < root.val && q.val < root.val){//left sub-tree
                root=root.left;
            }else if(p.val > root.val && q.val > root.val){//right sub-tree
                root = root.right;
            }else{
                ans=root;
                break;
            }
        }
        return ans;
    }
}