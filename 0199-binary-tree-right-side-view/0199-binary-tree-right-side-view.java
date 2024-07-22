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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        int level = 0;
        queue.offer(root);
        while(queue.size() > 0){
            int length = queue.size();
            while(length-->0){
                TreeNode node = queue.poll();
                if(!map.containsKey(level)){
                    map.put(level,0);
                }
                map.put(level,node.val);

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
           level++;
        }

        for(Integer key : map.keySet()){
            ans.add(map.get(key));
        }

        return ans;
    }
}