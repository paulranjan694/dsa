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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> lb = new ArrayList<>();
        List<Integer> rb = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        leftBoundary(root.left,lb);
        rightBoundary(root.right,rb);
        if(root.left != null || root.right != null)
            leaves(root,l);
        ans.add(root.val);

        for(int e:lb){
            ans.add(e);
        }

        for(int e:l){
            ans.add(e);
        }

        Collections.reverse(rb);

        for(int e:rb){
            ans.add(e);
        }
        return ans;

    }

    private void leftBoundary(TreeNode root, List<Integer> lb){
        if(root==null) return;
        if(root.left != null) {
            lb.add(root.val);
            leftBoundary(root.left,lb);
        }else if(root.right != null){
            lb.add(root.val);
            leftBoundary(root.right,lb);
        }
    }

    private void rightBoundary(TreeNode root, List<Integer> rb){
        if(root == null) return;
        if(root.right != null) {
            rb.add(root.val);
            rightBoundary(root.right,rb);
        }else if(root.left != null){
            rb.add(root.val);
            rightBoundary(root.left,rb);
        }
    }

    private void leaves(TreeNode root, List<Integer> l){
        if(root==null) return;
        if(root.left ==null && root.right == null) {
            l.add(root.val);
            return;
        }
        leaves(root.left,l);
        leaves(root.right,l);
    }
}