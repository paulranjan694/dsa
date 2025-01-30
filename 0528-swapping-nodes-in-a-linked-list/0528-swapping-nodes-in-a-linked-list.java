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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode frombeginning = null,fromlast=null,slow=head,fast=head;
        int count=1;
        while(count<k && fast !=null){
            fast=fast.next;
            count++;
        }
        frombeginning = fast;
       
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        
        fromlast=slow;
        int t = fromlast.val;
        fromlast.val = frombeginning.val;
        frombeginning.val = t;
        return head;
    }
}