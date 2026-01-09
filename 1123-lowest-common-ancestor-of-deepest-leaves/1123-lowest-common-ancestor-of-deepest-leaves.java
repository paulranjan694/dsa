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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair<TreeNode, Integer> pair = dfs(root);
        return pair.getKey();
    }

    private Pair<TreeNode,Integer> dfs(TreeNode root){
        if(root == null){
            return new Pair<TreeNode, Integer>(null,0);
        }

        Pair<TreeNode, Integer> left = dfs(root.left);
        Pair<TreeNode, Integer> right = dfs(root.right);

        if(left.getValue() == right.getValue()){
            return new Pair<TreeNode, Integer>(root, left.getValue()+1);
        }else if(left.getValue() > right.getValue()){
            return new Pair<TreeNode, Integer>(left.getKey(), left.getValue()+1);
        }else{
            return new Pair<TreeNode, Integer>(right.getKey(), right.getValue()+1);
        }
    }
}