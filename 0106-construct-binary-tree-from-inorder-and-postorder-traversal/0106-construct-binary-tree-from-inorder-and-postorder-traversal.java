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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        //Arrays.reverse(postorder);
        idx=inorder.length-1;
        return construct(postorder,map,0,inorder.length-1);
    }

    private TreeNode construct(int[] postorder,HashMap<Integer,Integer> map,int start,int end){
        if(start>end)return null;
        TreeNode root = new TreeNode(postorder[idx]);
        int partitionIdx = map.get(postorder[idx]);
        idx--;
        TreeNode right = construct(postorder,map,partitionIdx+1,end);
        TreeNode left = construct(postorder,map,start,partitionIdx-1);
       // idx++;
        root.left=left;
        root.right=right;
        return root;

    }
}