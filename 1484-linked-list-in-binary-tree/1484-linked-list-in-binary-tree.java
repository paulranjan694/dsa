/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        return findPath(head,root);
    }

    private boolean isPath(TreeNode root, ListNode head ){
        //base cond
        if( head == null) return true;
        if(root == null) return false;
        if(head.val != root.val){
           return false;
        }

       boolean left = isPath(root.left,head.next);
       boolean right = isPath(root.right,head.next);

       return left || right;
    }

    private boolean findPath(ListNode head, TreeNode root){
        if(root == null) return false;

        return isPath(root,head) || findPath(head,root.left) ||  findPath(head,root.right);
       
       


    }
}