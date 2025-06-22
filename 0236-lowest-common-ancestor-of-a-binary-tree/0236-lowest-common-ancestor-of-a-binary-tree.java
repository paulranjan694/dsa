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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        findNode(root,p,path1);
        findNode(root,q,path2);

        TreeNode ans=null;

        int i = 0;
    //    System.out.println(path1.toString());
    //    System.out.println(path2.toString());
        while(i<path1.size() && i < path2.size()){
            //System.out.println(path1.get(i).val+" --- "+path2.get(i).val);
            if(path1.get(i).val != path2.get(i).val){
                //System.out.println("inside non match");
                break;
            }
            ans=path1.get(i);
            i++;
        }
        return ans;
    }
    private boolean findNode(TreeNode root, TreeNode toFind, List<TreeNode> path){
        if(root == null){
            return false;
        }

        path.add(root);
        if(root.val==toFind.val){
            return true;
        }

        boolean findinLeftSubTree = findNode(root.left, toFind, path);
        if(findinLeftSubTree){
            return true;
        }
        boolean findinRightSubTree = findNode(root.right, toFind, path);
        if(findinRightSubTree){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}