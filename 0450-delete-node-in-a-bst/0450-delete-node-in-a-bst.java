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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        TreeNode curr = root;
        TreeNode prev = null;

        while(curr!=null){
            if(curr.val==key){
                if(prev==null){//delete root node
                    TreeNode temp = curr.left;
                    if(temp==null){
                        root=root.right;
                        return root;
                    }
                    TreeNode prev1 = null;
                    while(temp!=null && temp.right!=null){//search for rightmost node of left sub-tree
                        prev1=temp;
                        temp=temp.right;
                    }
                    if(prev1==null){//if no rightmost node in left sub-tree
                        if(temp.left==null){//check if no left child of the root of left sub-tree
                            root.val = temp.val;
                            root.left=null;
                        }else{ // make root->right to left subtree right and new root is the left subtree root
                            temp.right = root.right;
                            root.right=null;
                            root=temp;
                        }
                    }else{//if rightmost nod in left subtree present, make it root
                        root.val = temp.val;
                        prev1.right = null;
                    }
                    
                }else{
                    if(prev.left==curr){
                        if(curr.left!=null && curr.right!=null){//sub-tree root node with both child
                            prev.left = curr.right;
                            while(curr.right.left!=null){
                                curr.right=curr.right.left;
                            }
                            curr.right.left = curr.left;
                            curr.left=null;
                            curr.right=null;
                        }else if(curr.left==null && curr.right==null){//leaf node
                            prev.left = null;
                        }else if(curr.left!=null && curr.right==null){//sub-tree root node with left child only
                            prev.left = curr.left;
                            curr.left=null;
                        }else{//sub-tree root node with right child only
                            prev.left = curr.right;
                            curr.right=null;
                        }
                    }else{
                        if(curr.left!=null && curr.right!=null){//sub-tree root node with both child
                            prev.right = curr.right;
                            while(curr.right.left!=null){
                                curr.right=curr.right.left;
                            }
                            curr.right.left = curr.left;
                            curr.left=null;
                            curr.right=null;
                        }else if(curr.left==null && curr.right==null){//leaf node
                            prev.right = null;
                        }else if(curr.left!=null && curr.right==null){//sub-tree root node with left child only
                            prev.right = curr.left;
                            curr.left=null;
                        }else{//sub-tree root node with right child only
                            prev.right = curr.right;
                            curr.right=null;
                        }
                    }
                }
                return root;
            }else{
                prev=curr;
                if(curr.val > key){
                    curr=curr.left;
                }else{
                    curr=curr.right;
                }
            }
        }
        return root;
    }
}