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
    int idx;
    TreeNode node;
    Pair(int idx,TreeNode node){
        this.idx=idx;
        this.node=node;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int ans=0;
        q.offer(new Pair(0,root));

        while(!q.isEmpty()){
            int len = q.size();
            int first=0,last=0,minIdx=Integer.MAX_VALUE,cnt=0,length=len;
            while(len-- > 0){
                Pair p = q.poll();
                int idx = p.idx;
                TreeNode node = p.node;

                minIdx = Math.min(idx,minIdx);

                if(cnt==0){
                    first = idx;
                }
                if(cnt == length-1){
                    last = idx;
                }

                if(node.left != null){
                    q.offer(new Pair((2*(idx-minIdx) + 1),node.left));
                }

                if(node.right != null){
                    q.offer(new Pair((2*(idx-minIdx) + 2),node.right));
                }
                cnt++;
            }
            ans = Math.max(ans, (last-first+1));
        }
        return ans;
    }
}