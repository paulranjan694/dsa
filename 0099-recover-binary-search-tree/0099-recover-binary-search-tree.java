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
    TreeNode first,second,temp,prev;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if(first != null && second != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }else if(first != null && temp != null){
            int t = first.val;
            first.val = temp.val;
            temp.val = t;
        }
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);

        if(prev != null && prev.val > root.val){
            if(first==null){
                first = prev;
            }else{
                second=root;
            }
            temp=root;
        }else{
            prev = root;
        }

        inorder(root.right);
    }
}