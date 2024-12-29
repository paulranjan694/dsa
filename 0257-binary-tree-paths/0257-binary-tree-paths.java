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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root,ans,sb);
        return ans;
    }

    private void dfs(TreeNode root, List<String> ans,StringBuilder sb){
        if(root == null) return;
        if(root.left == null && root.right == null){
            StringBuilder sb1 = new StringBuilder(sb);
            sb1.append(root.val);
            ans.add(sb1.toString());
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        sb.append("->");
        dfs(root.left,ans,sb);
        dfs(root.right,ans,sb);
        sb.setLength(len);
    }
}