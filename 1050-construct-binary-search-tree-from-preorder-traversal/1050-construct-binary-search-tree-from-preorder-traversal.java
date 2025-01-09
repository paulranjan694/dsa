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
    public TreeNode bstFromPreorder(int[] pre) {
        int[] idx = new int[1];
        idx[0]=0;
        return utils(pre,Integer.MAX_VALUE,idx);
    }
    private TreeNode utils(int[] pre, int max, int[] idx){
        if(idx[0]==pre.length || pre[idx[0]] > max) return null;

        TreeNode node = new TreeNode(pre[idx[0]]);
        idx[0]++;
        node.left = utils(pre,node.val,idx);
        node.right = utils(pre,max,idx);
        return node;
    }
}