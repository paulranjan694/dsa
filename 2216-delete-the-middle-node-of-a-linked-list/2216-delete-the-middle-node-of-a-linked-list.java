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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null) return head;

        if(head.next == null) return null;

        ListNode fast = head.next.next;
        ListNode slow = head;
        //ListNode prev = null;

        while(fast!=null && fast.next!=null){
            //prev=slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //prev.next = slow.next;
        ListNode t = slow.next;
        slow.next = slow.next.next;
        t.next = null;

        return head;
    }
}