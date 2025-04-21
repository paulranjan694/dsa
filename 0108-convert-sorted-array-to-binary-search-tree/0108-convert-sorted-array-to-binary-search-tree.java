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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length-1;
        return utils(nums,0,n);
    }

    private TreeNode utils(int[] nums, int s, int e){
        if(s>e) return null;
        int m = (s+e)/2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = utils(nums,s,m-1);
        node.right = utils(nums,m+1,e);
        return node;
    }
}