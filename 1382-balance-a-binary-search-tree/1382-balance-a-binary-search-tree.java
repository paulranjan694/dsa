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
    List<Integer> nodes = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        int start=0, end = nodes.size()-1;
        return constructTree(start,end);
    }

    private TreeNode constructTree(int start, int end){
        if(start>end) return null;

        int mid = (start+end)/2;

        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = constructTree(start, mid-1);
        root.right = constructTree(mid+1, end);
        return root;
    }

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
    }
}