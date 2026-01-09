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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        List<TreeNode> leafNodes = bfs(root);

        List<List<TreeNode>> paths = new ArrayList();
        for(TreeNode leaf : leafNodes){
            List<TreeNode> path = new ArrayList<>();
            if(findPath(root,leaf,path))
                paths.add(path);
        }

        TreeNode lca = null;
        int minLen = paths.stream().mapToInt(List::size).min().getAsInt();

        for (int i = 0; i < minLen; i++) {
            TreeNode curr = paths.get(0).get(i);
            for (List<TreeNode> p : paths) {
                if (p.get(i) != curr) {
                    return lca;
                }
            }
            lca = curr;
        }
        return lca;

    }

    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path){
        if(root == null){
            return false;
        }

        if(root == target){
            path.add(root);
            return true;
        }

        path.add(root);
        boolean left = findPath(root.left,target,path);
        if(left) return true;
        boolean right = findPath(root.right,target,path);
        if(right) return true;
        path.remove(path.size()-1);
        return false;
    }

    private List<TreeNode> bfs(TreeNode root){
        List<TreeNode> deepestLevel = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            deepestLevel.clear();
            while(size-- > 0){
                TreeNode node = q.poll();
                deepestLevel.add(node);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }

        return deepestLevel;
    }
}