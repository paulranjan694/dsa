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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        int ans=-1;
        int maxSum=Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        int level=1;
        queue.offer(root);
        while(queue.size() > 0){
            int length = queue.size();
            int sum=0;
            while(length-->0){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                ans=level;
            }
            level++;
        }
        return ans;
    }
}