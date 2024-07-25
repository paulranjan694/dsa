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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodeVal = new ArrayList<>();
        inorder(root, nodeVal);

       // Collections.sort(nodeVal);
        //Map<Integer,Integer> map = new HashMap<>();
        int start = 0;
        int end = nodeVal.size()-1;
        int mid = (start+end)/2;
        TreeNode node = constructTree(nodeVal, start, end);
        return node;
    }

    public TreeNode constructTree(List<Integer> nodeVal, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nodeVal.get(mid));

        root.left = constructTree(nodeVal, start, mid-1);
        root.right = constructTree(nodeVal, mid+1, end);
        return root;
    }

    public void inorder(TreeNode root, List<Integer> list){
        if(root==null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}