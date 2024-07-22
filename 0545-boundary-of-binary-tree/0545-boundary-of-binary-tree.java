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
        if(root == null) return ans;
        ans.add(root.val);
        leftboundary(root.left, ans);
        addLeafNode(root.left,ans);
        addLeafNode(root.right,ans);
        rightboundary(root.right, ans);
        return ans;
    }

    public void leftboundary(TreeNode root, List<Integer> res){
        if(root == null || root.left == null && root.right == null) return;
            res.add(root.val);
        if(root.left !=null)
            leftboundary(root.left,res);
        else if(root.right!=null)
            leftboundary(root.right,res);
    }

    public void addLeafNode(TreeNode root, List<Integer> res){
        if(root == null) return;
        if(root.left == null && root.right == null){
             res.add(root.val);
             return;
        }
        addLeafNode(root.left,res);
        addLeafNode(root.right,res);
    }

    public void rightboundary(TreeNode root, List<Integer> res){
        if(root == null || root.left == null && root.right == null) return;
        if(root.right!=null)
            rightboundary(root.right,res);
        else
            rightboundary(root.left,res);
        res.add(root.val);
    }
}