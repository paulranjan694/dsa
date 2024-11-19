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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;

        ListNode slow = head,fast=head,prev=null;

        int i=0;
        while(i<n && fast != null){
            fast = fast.next;
            i++;
        }

        while(fast!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }

        if(prev!=null){
            prev.next=slow.next;
            slow.next=null;
        }else{
            head=head.next;
        }

        return head;

    }
}