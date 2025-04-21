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
    private int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return utils(preorder,map,0,preorder.length-1);
    }

    private TreeNode utils(int[] preorder, Map<Integer,Integer> map, int start, int end){
        if(start > end || index>=preorder.length) return null;

        TreeNode node = new TreeNode(preorder[index]);
        int idx = map.get(preorder[index]);
        index++;
        
        node.left = utils(preorder,map,start,idx-1);
        node.right = utils(preorder,map,idx+1,end);
        return node;
    }
}