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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);

        while(queue.size() > 0){
            int length  = queue.size();
            List<Integer> list = new ArrayList<>();
            while(length-- > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            if(level % 2 != 0 )
                Collections.reverse(list);
            ans.add(list);
            level++;
        }
        return ans;
    }
}