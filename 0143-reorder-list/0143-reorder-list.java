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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        ListNode slow = head,fast=head,prev=null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow = slow.next;
            fast=fast.next.next;
        }
        prev=slow;
        slow=slow.next;
        prev.next=null;
        ListNode h2 = reverse(slow);
        ListNode h1 = head;
        // ListNode thead= new ListNode(-1);
        // ListNode th=thead;
        while(h1!=null && h2!=null){
            ListNode t1 = h1.next;
            ListNode t2 = h2.next;
            h1.next = h2;
            h2.next = t1;

            h1 = t1;
            h2=t2;
        }

        //  while(h1!=null){
        //     ListNode t = h1.next;
        //     th.next = h1;
        //     h1.next=null;
        //     h1=t;
        //     th=th.next;
        // }

        //  while(h2!=null){
        //     ListNode t = h2.next;
        //     th.next = h2;
        //     h2.next=null;
        //     h2=t;
        //     th=th.next;
        // }
        // head=thead.next;

    }

    private ListNode reverse(ListNode h1){
        if(h1 == null || h1.next == null)
            return h1;

        ListNode next=null,prev=null;
        while(h1 != null){
            next=h1.next;
            h1.next=prev;
            prev=h1;
            h1=next;
        }
        return prev;
    }
}