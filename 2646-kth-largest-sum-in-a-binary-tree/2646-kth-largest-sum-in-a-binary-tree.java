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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
         PriorityQueue<Long> pq = new PriorityQueue<Long>();
        queue.offer(root);
        int level=0;

        while(!queue.isEmpty()){
            int len = queue.size();
            long sum=0l;
            while(len-- > 0){
                TreeNode node = queue.poll();
                sum+=node.val;

                if(node.left != null)
                    queue.offer(node.left);

                if(node.right != null)
                    queue.offer(node.right);
            }
            if(pq.size()>=k && pq.peek() < sum){
                pq.poll();
                pq.add(sum);
            }
            if(pq.size() < k){
                pq.add(sum);
            }
            level++;

        }
        if(level < k)
            return -1;
        return pq.peek();
    }
}