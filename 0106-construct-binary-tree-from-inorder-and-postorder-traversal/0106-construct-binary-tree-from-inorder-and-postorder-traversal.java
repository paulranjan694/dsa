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
    int postOrderIndex=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        postOrderIndex = postorder.length-1;
        return constructTreeHelper(map, postorder, 0, postorder.length-1);
    }

    public TreeNode constructTreeHelper( Map<Integer,Integer> map , int[] postorder, int startIndex, int endIndex){
        if(startIndex>endIndex)
            return null;

        int val = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(val);

        root.right = constructTreeHelper(map, postorder, map.get(val)+1, endIndex);
        root.left = constructTreeHelper(map, postorder, startIndex, map.get(val)-1);
        return root;
    }
}