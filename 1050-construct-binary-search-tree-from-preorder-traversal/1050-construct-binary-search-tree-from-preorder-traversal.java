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
    int idx=1;
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
       // TreeNode node = root;
        utils(root,preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return root;
    }

    private void utils(TreeNode root, int[] preorder, int min, int max){
        if(root==null || preorder.length ==idx) return;
        
        TreeNode node = null;
        if(idx < preorder.length && preorder[idx] > min && preorder[idx] < root.val){
            node = new TreeNode(preorder[idx++]);
            root.left=node;
        }

        utils(root.left,preorder,min,root.val);

        if(idx < preorder.length && preorder[idx] < max && preorder[idx] > root.val){
            node = new TreeNode(preorder[idx++]);
            root.right=node;
        }
        utils(root.right,preorder,root.val,max);

    }
}