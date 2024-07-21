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
        int[] maxsum = new int[1];
        maxsum[0]=-10000;
        dfsHeight(root, maxsum);
        return maxsum[0];
    }

    public int dfsHeight(TreeNode root, int[] maxsum){
        if(root == null) return 0;

        int lh = Math.max(0,dfsHeight(root.left, maxsum));
        int rh = Math.max(0,dfsHeight(root.right, maxsum));
        maxsum[0] = Math.max(maxsum[0],lh+rh+root.val);
        return Math.max(lh,rh)+root.val;
    }
}