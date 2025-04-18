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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        return dfs(root,map,0L,targetSum);

        
    }

    private int dfs(TreeNode root,  Map<Long,Integer> map, long sum, int targetSum){
        if(root == null) return 0;
        sum += root.val;
        int pathsEndingHere = map.getOrDefault(sum-targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        int left = dfs(root.left,map,sum, targetSum);
        int right = dfs(root.right,map,sum,targetSum);
        int totals = pathsEndingHere + left + right;
        map.put(sum, map.getOrDefault(sum, 0) - 1);
        return totals;

    }
}