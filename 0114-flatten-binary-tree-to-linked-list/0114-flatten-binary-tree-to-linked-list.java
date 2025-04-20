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

    public void flatten(TreeNode root) { //moris traversal -> tc - O(n) sc - O(1)
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode rightmost = curr.left;
                while(rightmost.right != null){
                    rightmost=rightmost.right;
                }
                rightmost.right = curr.right;
                curr.right = curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
    }
    
    // TreeNode prev = null;
    // public void flatten_reverse_postorder(TreeNode root) {//reverse post-order -> tc - O(n) sc - O(n) => stack space
    //     if(root==null) return;

    //     flatten(root.right);
    //     flatten(root.left);

    //     root.right = prev;
    //     root.left = null;
    //     prev=root;
    // }
}