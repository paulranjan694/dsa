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
    // List<Integer> res = new ArrayList<>();
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if(root==null) return res;
    //     res.add(root.val);
    //     preorderTraversal(root.left);
    //     preorderTraversal(root.right);
    //     return res;
    // }

    //Moris Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while(curr!=null){
            if(curr.left==null){
                res.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }

                if(prev.right == null){
                    res.add(curr.val);
                    prev.right = curr;
                    curr = curr.left;
                }else{
                     prev.right = null;
                     curr=curr.right;
                }
            }
        }
        return res;
    }

}