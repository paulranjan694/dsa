/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parents = new HashMap<>();
        findParents(root,null,parents);
        return bfsFindKthDistance(parents, target, k);
    }

    public List<Integer> bfsFindKthDistance(Map<TreeNode,TreeNode> parents,TreeNode target, int k){
        List<Integer> ans= new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        while(k-- > 0){
            int len = queue.size();
            while(len-- > 0){
                TreeNode node = queue.poll();
                if(!visited.contains(node))
                    visited.add(node);

                TreeNode parent = parents.getOrDefault(node,null);

                if(parent!=null && !visited.contains(parent)) queue.offer(parent);
                if(node.left != null && !visited.contains(node.left)) queue.offer(node.left);
                if(node.right != null && !visited.contains(node.right)) queue.offer(node.right);
            }
        }
        while(!queue.isEmpty()){
            int ele = queue.poll().val;
            ans.add(ele);
        }
        return ans;
    }

    public void findParents(TreeNode root, TreeNode parentNode, Map<TreeNode,TreeNode> parents){
        if(root == null) return;
        parents.put(root,parentNode); 
        findParents(root.left,root,parents);
        findParents(root.right,root,parents);
    }
}