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
    private final int MAX_LENGTH_OF_TREE = 100001;
    private int[] level = new int[MAX_LENGTH_OF_TREE];
    private int[] height = new int[MAX_LENGTH_OF_TREE];
    private int[] levelMaxHt = new int[MAX_LENGTH_OF_TREE];
    private int[] levelSecMaxHt = new int[MAX_LENGTH_OF_TREE];

    public int[] treeQueries(TreeNode root, int[] queries) {
        findHeight(root,0);

        int[] result = new int[queries.length];
        int index=0;
        for(int query : queries){
            int L = level[query];
            result[index++] = L + (levelMaxHt[L]== height[query] ? levelSecMaxHt[L] : levelMaxHt[L]) - 1;
        }

        return result;
    }

    private int findHeight(TreeNode root, int l){
        if(root == null) return 0;
        level[root.val] = l;
        height[root.val] = Math.max(findHeight(root.left,l+1),findHeight(root.right, l+1)) + 1;

        if(height[root.val] > levelMaxHt[l]){
            levelSecMaxHt[l] = levelMaxHt[l];
            levelMaxHt[l] = height[root.val];
        }else if(height[root.val] > levelSecMaxHt[l]){
            levelSecMaxHt[l] = height[root.val];
        }
        return height[root.val];
    }
}