/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "$";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0){
            int length = queue.size();
            List<Integer> list = new ArrayList<>();
            while(length-->0){
                TreeNode node = queue.poll();
                
                if(node==null) sb.append("$ ");
                else sb.append(node.val+" ");
                
                if(node !=null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0 || data.charAt(0) == '$') return null;
        String[] val = data.split(" ");
       Queue<TreeNode> queue = new LinkedList<>();
       TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        queue.offer(root);
        int idx=1;
        while(queue.size() > 0){
            int length = queue.size();
            while(length-->0){
                TreeNode node = queue.poll();
                if("$".equals(val[idx])){
                    node.left = null;
                }else{
                    TreeNode temp = new TreeNode(Integer.parseInt(val[idx]));
                    node.left = temp;
                    queue.offer(temp);
                }

                idx++;
                 if("$".equals(val[idx])){
                    node.right = null;
                }else{
                    TreeNode temp = new TreeNode(Integer.parseInt(val[idx]));
                    node.right = temp;
                    queue.offer(temp);
                }
                idx++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));