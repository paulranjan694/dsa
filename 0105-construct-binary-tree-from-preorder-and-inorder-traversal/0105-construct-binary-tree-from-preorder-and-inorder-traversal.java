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
    private int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return construct(preorder,map,0,inorder.length-1);
    }

    private TreeNode construct(int[] preorder,HashMap<Integer,Integer> map,int start,int end){
        if(start>end)return null;
        TreeNode root = new TreeNode(preorder[idx]);
        int partitionIdx = map.get(preorder[idx]);
        idx++;
        TreeNode left = construct(preorder,map,start,partitionIdx-1);
       // idx++;
        TreeNode right = construct(preorder,map,partitionIdx+1,end);
        root.left=left;
        root.right=right;
        return root;

    }
}