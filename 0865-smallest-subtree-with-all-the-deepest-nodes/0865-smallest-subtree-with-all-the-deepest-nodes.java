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

class Result{
    int depth;
    TreeNode node;
    Result(int d, TreeNode n){
        this.depth = d;
        this.node = n;
    }
}

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return root;

        Result res = dfs(root);

        return res.node;
    }

    private Result dfs(TreeNode root){
        if(root == null){
            return new Result(-1, null);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if(left.depth == right.depth){
            int depth = left.depth == -1 ? 1 : left.depth + 1;
            return new Result(depth, root);
        }else if(left.depth > right.depth){
            int depth = left.depth + 1;
            return new Result(depth, left.node);
        }else{
            int depth = right.depth + 1;
            return new Result(depth, right.node);
        }
    }
}