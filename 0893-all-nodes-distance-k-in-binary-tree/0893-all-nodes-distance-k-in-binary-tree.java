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
        Map<TreeNode,TreeNode> map = new HashMap<>();
        map.put(root,null);
        dfs(root,map);
        //TreeNode node = searchNode(root,target);
        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        bfs(target,k,map,ans,set);
        return ans;
    }

    private void bfs(TreeNode node, int k, Map<TreeNode,TreeNode> map,List<Integer> ans,Set<TreeNode> set){
        if(node==null)return;
        if(k==0){
            ans.add(node.val);
            return;
        }
        set.add(node);
        if(node.left != null && !set.contains(node.left)){
            bfs(node.left,k-1,map,ans,set);
        }

        if(node.right != null && !set.contains(node.right)){
            bfs(node.right,k-1,map,ans,set);
        }

        TreeNode parentNode = map.get(node);
        if(parentNode != null && !set.contains(parentNode)){
            bfs(parentNode,k-1,map,ans,set);
        }
    }

    private void dfs(TreeNode root, Map<TreeNode,TreeNode> map){
        if(root==null) return;
        dfs(root.left,map);
        dfs(root.right,map);
        if(root.left != null){
            map.put(root.left,root);
        }
        if(root.right != null){
            map.put(root.right,root);
        }
    }


    private TreeNode searchNode(TreeNode root, TreeNode target){
        if(root == null || root == target) return root;
        TreeNode left = searchNode(root.left,target);
        if(left==target)
            return left;
        TreeNode right = searchNode(root.right,target);
        if(right==target)
            return right;
        return null;
    }
}