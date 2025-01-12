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

 
class NodeValue{
    int size,min,max;
    NodeValue(int size, int max, int min){
        this.size=size;
        this.max=max;
        this.min=min;
    }
}


class Solution {
    public int largestBSTSubtree(TreeNode root) {
        return largestBSTSubtreeHelper(root).size;
    }

    private NodeValue largestBSTSubtreeHelper(TreeNode root){
        if(root == null) return new NodeValue(0,Integer.MIN_VALUE,Integer.MAX_VALUE);

        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);

        if(left.max < root.val && root.val < right.min){
            return new NodeValue(1 + left.size + right.size,Math.max(root.val,right.max),Math.min(left.min,root.val));
        }

        return new NodeValue(Math.max(left.size,right.size),Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
}