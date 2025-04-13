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
    private static List<TreeNode> list=null;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();
        for(int val : to_delete){
            toDelete.add(val);
        }
        list = new ArrayList<>();

        root = dfs(root,toDelete);
        if(root != null){
            list.add(root);
        }
        return list;

    }

    private TreeNode dfs(TreeNode node, Set<Integer> toDelete){
        if(node==null) return null;
        node.left = dfs(node.left,toDelete);
        node.right = dfs(node.right,toDelete);
        if(toDelete.contains(node.val)){
            if(node.left != null){
                list.add(node.left);
            }

            if(node.right != null){
                list.add(node.right);
            }
            return null;
        }
        return node;
    }
}