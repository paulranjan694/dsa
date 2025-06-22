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
    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[]{k};
        return kthSmallestHelper(root,arr);
    }

    public int kthSmallestHelper(TreeNode root, int[] kthArr) {
        if(root == null) return -1;
       
        int leftKth = kthSmallestHelper(root.left,kthArr);
        if(leftKth >= 0) return leftKth;
        kthArr[0]--;
        if(kthArr[0]==0) return root.val;
        int rightKth = kthSmallestHelper(root.right,kthArr);
        if(rightKth >= 0) return rightKth;
        return -1;
    }
}