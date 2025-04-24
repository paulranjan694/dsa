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
    List<TreeNode> result = null;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();

        for(int node : to_delete){
            toDelete.add(node);
        }
        result = new ArrayList<>();
        TreeNode node = dfs(root,toDelete);
        if(node != null){
            result.add(node);
        }
        return result;

    }

    private TreeNode dfs(TreeNode root, Set<Integer> toDelete){
        if(root == null){
            return root;
        }

        root.left = dfs(root.left,toDelete);
        root.right = dfs(root.right,toDelete);

        if(toDelete.contains(root.val)){
            if(root.left != null){
                result.add(root.left);
                root.left = null;
            }

            if(root.right != null){
                result.add(root.right);
                root.right = null;
            }

            return null;
        }
        return root;
    }
}