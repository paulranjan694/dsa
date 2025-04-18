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
        int[] ans = new int[1];
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();

            while(len-- > 0){
                TreeNode node = queue.poll();
                dfs(node,targetSum,ans,0);

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return ans[0];
    }

    private void dfs(TreeNode root, int targetSum, int[] ans, long sum){
        if(root == null) return;
        sum += root.val;

        if(sum==targetSum){
            ans[0]++;
        }

        // if(sum < 0){
        //    return;
        // }

        dfs(root.left,targetSum,ans,sum);
        //dfs(root.left,targetSum,ans,targetSum);

        dfs(root.right,targetSum,ans,sum);
        //dfs(root.right,targetSum,ans,targetSum);
    }
}