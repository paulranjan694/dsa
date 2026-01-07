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
    private final int MOD = 1_000_000_007;
    long max=Long.MIN_VALUE;
    public int maxProduct(TreeNode root) {
        if(root == null) return 0;
        long totalSum = findSum(root);
        findMax(root, totalSum);
        return (int)(max % MOD);
    }

    private long findMax(TreeNode root, long totalSum){
        if(root == null) return 0;
        long left = findMax(root.left, totalSum);
        long right = findMax(root.right, totalSum);

        long subTreeSum = left + right + root.val;

        max = Math.max(max, (((totalSum - subTreeSum) * subTreeSum)));
        return subTreeSum;
    }

    private long findSum(TreeNode root){
        if(root == null) return 0;

        long left = findSum(root.left);
        long right = findSum(root.right);

        return root.val + left + right;
    }
}