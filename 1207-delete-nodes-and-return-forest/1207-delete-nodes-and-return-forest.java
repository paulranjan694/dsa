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
class NodeInfo{
    TreeNode parent,left,right;
    String child;
    NodeInfo(TreeNode p, String child,TreeNode left, TreeNode right){
        this.parent=p;
        this.child=child;
        this.left=left;
        this.right=right;
    }
}

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Map<Integer,NodeInfo> map = new HashMap<>();
        dfs(root,map,null,null);
        List<TreeNode> list = new ArrayList<>();
        Map<Integer,TreeNode> temp = new HashMap<>();
        boolean isrootdeleted = false;
        int[] deleteMap = new int[1001];
        for(int val : to_delete){
            deleteMap[val]++;
            NodeInfo node = map.get(val);

            if(temp.containsKey(val)){
                temp.remove(val);
            }
            
            if(node.left!=null){
                temp.put(node.left.val,node.left);
            }

            if(node.right != null){
                temp.put(node.right.val,node.right);
            }

            node.left=null;
            node.right=null;
        
            if(node.parent != null){//deleting node other than root
                TreeNode parent = node.parent;
                if(node.child.equals("left")){
                    parent.left=null;
                }else{
                    parent.right=null;
                }
            }else{//deleting root
                isrootdeleted = true;
            }
        }

        if(!isrootdeleted){
            list.add(root);
        }

        for(TreeNode node : temp.values()){
            if(deleteMap[node.val] == 0)
                list.add(node);
        }
        return list;
    }

    private void dfs(TreeNode root,  Map<Integer,NodeInfo> map,TreeNode parent,String child){
        if(root==null){
            return;
        }
        NodeInfo nodeInfo = new NodeInfo(parent, child, root.left, root.right);
        map.put(root.val,nodeInfo);
        dfs(root.left,map,root,"left");
        dfs(root.right,map,root,"right");
    }
}