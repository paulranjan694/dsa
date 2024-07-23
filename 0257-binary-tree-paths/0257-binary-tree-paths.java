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
      List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        if(root == null) return ans;
        StringBuilder path = new StringBuilder();
        dfsPath(root, path);
        return ans;
    }

    public void dfsPath(TreeNode root,  StringBuilder path){
        if(root == null) return;
        int size = path.length();
        if(root.left==null && root.right == null){
            path.append(root.val);
            ans.add(path.toString());
            path.setLength(size);
            return;
        }
        path.append(root.val+"->");
        dfsPath(root.left, path);
        dfsPath(root.right, path);
        path.setLength(size);

    }
}