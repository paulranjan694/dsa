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
        if(root == null){
            return "#";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            while(len-- > 0){
                TreeNode node = queue.poll();
                if(node == null){
                    sb.append("#").append(" ");
                }
                else sb.append(node.val).append(" ");
                if(node != null){
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("#")) return null;

        String[] nodes = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        int index=1;

        while(!queue.isEmpty()){
            int len = queue.size();
            while(len-- > 0){
                TreeNode node = queue.poll();
                if(!"#".equals(nodes[index])){
                    node.left = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.add(node.left);
                }
                index++;

                if(!"#".equals(nodes[index])){
                    node.right = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.add(node.right);
                }
                index++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));