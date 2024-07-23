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
        if(root.left==null && root.right == null){
            ans.add(Integer.toString(root.val));
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfsPath(root.left, path);
        dfsPath(root.right, path);
        return ans;
    }

    public void dfsPath(TreeNode root,  List<Integer> path){
        if(root == null) return;
        if(root.left==null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int e : path){
                sb.append(e+"->");
            }
            sb.append(root.val);
            ans.add(sb.toString());
            return;
        }
        path.add(root.val);
        dfsPath(root.left, path);
        dfsPath(root.right, path);
        path.remove(path.size()-1);

    }
}