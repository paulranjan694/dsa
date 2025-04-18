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
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        dfs(root,ans);
        return ans[0];
    }

    private int dfs(TreeNode root, int[] ans){
        if(root == null) return 0;

        int left = dfs(root.left,ans);
        int right = dfs(root.right,ans);

        int temp = Math.max(Math.max(left,right)+root.val,root.val);
        int res = Math.max(temp,left+right+root.val);
        ans[0] = Math.max(ans[0],res);
        return temp;
    }
}