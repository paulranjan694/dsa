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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        List<Integer> list =new ArrayList<>();

        dfs(root, list);

        for(int i=1;i<list.size();i++){
            if(list.get(i-1) >= list.get(i)){
                return false;
            }
        }
        return true; 
    }

    public void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}