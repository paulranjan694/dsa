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
        addLeafNode(root,ans, true);
        Stack<Integer> st = new Stack<>();
        rightboundary(root.right, st);
        while(!st.empty()){
            int e = st.pop();
            ans.add(e);
        }
        return ans;
    }

    public void leftboundary(TreeNode root, List<Integer> res){
        if(root == null || root.left == null && root.right == null) return;
        if(root.left !=null){
            res.add(root.val);
            leftboundary(root.left,res);
        }else if(root.right!=null){
            res.add(root.val);
            leftboundary(root.right,res);
        }
    }

    public void addLeafNode(TreeNode root, List<Integer> res, boolean isRoot){
        if(root == null) return;
        if(root.left == null && root.right == null && !isRoot){
             res.add(root.val);
             return;
        }
        addLeafNode(root.left,res, false);
        addLeafNode(root.right,res, false);
    }

    public void rightboundary(TreeNode root, Stack<Integer> res){
        if(root == null || root.left == null && root.right == null) return;
        if(root.right!=null){
            res.push(root.val);
            rightboundary(root.right,res);
        }else if(root.left !=null){
            res.push(root.val);
            rightboundary(root.left,res);
        }
    }
}