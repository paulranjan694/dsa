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
    int level;
    TreeNode node;
    Pair(TreeNode node,int index, int level){
        this.index = index;
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       List<List<Integer>> res = new ArrayList<>();
       if(root == null) return res;

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        int level = 0;
        queue.offer(new Pair(root,0,level));
        while(!queue.isEmpty()){
            level++;
            int length = queue.size();
            while(length-- > 0){
                Pair p = queue.poll();
                int index = p.index;
                TreeNode node = p.node;
                int nodelevel = p.level;
                
                if(!map.containsKey(index)){
                    map.put(index, new TreeMap<>());
                }

                if(!map.get(index).containsKey(nodelevel)){
                    map.get(index).put(nodelevel, new PriorityQueue<>());
                }

                map.get(index).get(nodelevel).offer(node.val);
               

                if(node.left != null){
                    queue.offer(new Pair(node.left, index-1, level));
                }

                if(node.right != null){
                    queue.offer(new Pair(node.right, index+1,level));
                }
            }
        }

        for(Map.Entry<Integer,Map<Integer,PriorityQueue<Integer>>> entry : map.entrySet()){
            int key = entry.getKey();
            Map<Integer,PriorityQueue<Integer>> value = entry.getValue();
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : value.values()){
                while(!nodes.isEmpty()){
                    int e = nodes.poll();
                    list.add(e);
                }
            }
            res.add(list);
        }
        return res;
    }
}