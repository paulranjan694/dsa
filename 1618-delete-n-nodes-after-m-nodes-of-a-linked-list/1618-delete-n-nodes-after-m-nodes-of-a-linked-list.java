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
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr=head,prev=null;
        while(curr != null){
          for(int i=1;i<=m && curr!=null;i++){
            prev=curr;
            curr = curr.next;
          }
          for(int i=1;i<=n && curr!=null;i++){
            curr=curr.next;
          }
          prev.next = curr;
        }
        return head;
    }
}