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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans=new int[1];
        dfs(root,ans);
        return ans[0];
    }

    private int dfs(TreeNode root,int[] ans){
        //base cond
        if(root == null) return 0;

        //hypothesis
        int left = dfs(root.left,ans);
        int right = dfs(root.right,ans);

        //induction
        int temp = Math.max(left,right) + 1;
        //int tempans = Math.max(temp,1+left+right);//if asked for total nodes
       // int tempans = Math.max(temp,left+right);//total edges
        ans[0] = Math.max(ans[0],left+right);
        return temp;
    }
}