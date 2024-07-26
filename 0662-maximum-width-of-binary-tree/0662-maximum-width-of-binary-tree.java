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
 class Pair{
    int index;
    TreeNode node;

    Pair(TreeNode node,int index){
        this.node=node;
        this.index=index;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans=0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));

        while(!queue.isEmpty()){
            int len = queue.size();
            int minIdx = queue.peek().index;
            int first=0,last=0;

            for(int i=0;i<len;i++){
                int currIdx = queue.peek().index - minIdx;
                TreeNode node = queue.peek().node;
                queue.poll();
                
                if(i==0) first = currIdx;
                if(i==len-1) last = currIdx;

                if(node.left != null){
                    queue.offer(new Pair(node.left, currIdx*2+1));
                }

                if(node.right != null){
                    queue.offer(new Pair(node.right, currIdx*2+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}