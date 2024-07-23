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
    int preOrderIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return constructTreeHelper(map, preorder, 0, preorder.length-1);
    }

    public TreeNode constructTreeHelper( Map<Integer,Integer> map , int[] preorder, int startIndex, int endIndex){
        if(startIndex>endIndex)
            return null;

        int val = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(val);

        root.left = constructTreeHelper(map, preorder, startIndex, map.get(val)-1);
        root.right = constructTreeHelper(map, preorder, map.get(val)+1, endIndex);
        return root;
    }
}