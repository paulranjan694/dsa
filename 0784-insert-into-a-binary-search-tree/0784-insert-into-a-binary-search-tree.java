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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }

        TreeNode curr = root;
        while(curr != null){
            if(curr.val <= val){
                if(curr.right == null){
                    TreeNode node = new TreeNode(val);
                    curr.right = node;
                    break;
                }else
                    curr = curr.right;
            }else{
                if(curr.left == null){
                    TreeNode node = new TreeNode(val);
                    curr.left = node;
                    break;
                }else
                    curr=curr.left;
            }
        }
        return root;
    }
}