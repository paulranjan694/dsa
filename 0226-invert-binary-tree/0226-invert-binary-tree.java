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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode node = new TreeNode(root.val);
        helper(root.left, node,0);
        helper(root.right, node,1);
        return node;
    }

    public void helper(TreeNode root, TreeNode node, int idx){
        if(root == null) return;
        TreeNode tempNode = new TreeNode(root.val);
        if(idx==0)
            node.right = tempNode;
        if(idx==1)
            node.left = tempNode;

        helper(root.left, tempNode, 0);
        helper(root.right, tempNode, 1);
    }

}