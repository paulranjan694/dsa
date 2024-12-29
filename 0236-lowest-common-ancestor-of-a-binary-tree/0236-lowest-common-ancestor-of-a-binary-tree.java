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
    boolean found = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> path1 = new LinkedHashSet<>();
        Set<TreeNode> path2 = new LinkedHashSet<>();

        dfs(root,p,path1);
        found=false;
        dfs(root,q,path2);
        TreeNode lca=null;
        
        // System.out.println("path2...");
        // for(TreeNode node : path2){
        //     System.out.println(node.val);
        // }

        // System.out.println("path1...");
        // for(TreeNode node : path1){
        //     System.out.println(node.val);
        // }

        for(TreeNode node : path2){
            if(path1.contains(node)){
                lca=node;
            }
        }
        return lca;
    }

    private void dfs(TreeNode root, TreeNode p, Set<TreeNode> p1){
        if(root==null) return;
        if(root==p){
            found=true;
            p1.add(root);
            return;
        }
        p1.add(root);
        dfs(root.left,p,p1);
        if(found == true) return;
        dfs(root.right,p,p1);
        if(found == true) return;
        if(found==false){
            p1.remove(root);
        }
    }
}