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
    private List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return result;
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int level){
        if(result.size() == level) result.add(root.val);

        if(root.right != null) helper(root.right, level+1);
        if(root.left != null) helper(root.left, level+1);
    }
}