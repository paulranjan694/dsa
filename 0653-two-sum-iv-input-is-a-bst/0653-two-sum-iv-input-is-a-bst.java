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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);

        int i=0,j=list.size()-1;
        while(i<j){
            int sum = list.get(i)+list.get(j);
            if(sum==k){
                return true;
            }else if(sum > k){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

    private void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);

    }
}