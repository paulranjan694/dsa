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
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(root,targetSum,paths,path);
        return paths;
    }

    private void helper(TreeNode root, int targetSum, List<List<Integer>> paths, List<Integer> path){
        if(root == null) return;
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            path.add(root.val);
            paths.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        path.add(root.val);
        helper(root.left,targetSum,paths,path);
        helper(root.right,targetSum,paths,path);
        path.remove(path.size()-1);
    }
}