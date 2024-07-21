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
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
           boolean leftToRight = true;

        while(!queue.isEmpty()){
            int length  = queue.size();
            LinkedList<Integer> list = new LinkedList<Integer>();
            for(int i=0;i<length;i++){
                TreeNode node = queue.poll();
                if(leftToRight){
                    list.addLast(node.val);
                }else{
                    list.addFirst(node.val);
                }
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            ans.add(list);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}