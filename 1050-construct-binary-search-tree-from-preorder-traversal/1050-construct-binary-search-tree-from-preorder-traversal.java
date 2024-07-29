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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }

    public TreeNode helper(int[] preorder,int start, int end){
        //base condition
        if(start > end)
            return null;

        TreeNode root = new TreeNode(preorder[start]);
        int pivot=start+1;
        while(pivot <= end && preorder[pivot] <= preorder[start]){
            pivot++;
        }
        
        root.left = helper(preorder, start+1, pivot-1);
        root.right = helper(preorder, pivot, end);
        return root;
    }

}