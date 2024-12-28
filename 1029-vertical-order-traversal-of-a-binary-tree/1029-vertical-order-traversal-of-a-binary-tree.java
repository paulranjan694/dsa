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
    int r,c;
    TreeNode node;

    Pair(int r, int c, TreeNode n){
        this.r=r;
        this.c=c;
        this.node=n;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> hm = new TreeMap<>();
        q.add(new Pair(0,0,root));
        while(!q.isEmpty()){
            int len = q.size();
            while(len-- > 0){
                Pair p = q.poll();
                int r = p.r;
                int c = p.c;
                TreeNode node = p.node;

                // if(hm.containsKey(c)){
                //     Map<Integer,PriorityQueue<Integer>> map = hm.get(c);
                //     if(map.containsKey(r)){
                //         PriorityQueue pq = map.get(r);
                //         pq.add(node.val);
                //         map.put(r,pq);
                //     }else{
                //         PriorityQueue<Integer> pq = new PriorityQueue<>();
                //         pq.add(node.val);
                //         map.put(r,pq);
                //     }
                // }else{
                //     Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
                //     PriorityQueue<Integer> pq = new PriorityQueue<>();
                //     pq.add(node.val);
                //     map.put(r,pq);
                //     hm.put(c,map);
                // }

                if(!hm.containsKey(c)){
                    hm.put(c,new TreeMap<>());
                }

                if(!hm.get(c).containsKey(r)){
                    hm.get(c).put(r, new PriorityQueue<>());
                }

                hm.get(c).get(r).add(node.val);

                if(node.left != null){
                    q.add(new Pair(r+1,c-1,node.left));
                }

                if(node.right != null){
                    q.add(new Pair(r+1,c+1,node.right));
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
    
        for(Map.Entry<Integer,Map<Integer,PriorityQueue<Integer>>> entry : hm.entrySet()){
            Map<Integer,PriorityQueue<Integer>> m = entry.getValue();
            List<Integer> list = new ArrayList<>();
            for(Map.Entry<Integer,PriorityQueue<Integer>> en : m.entrySet()){
                PriorityQueue<Integer> pq = en.getValue();
                while(!pq.isEmpty()){
                    int e = pq.poll();
                    list.add(e);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}