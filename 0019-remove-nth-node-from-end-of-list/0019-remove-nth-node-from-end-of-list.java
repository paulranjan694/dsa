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
        if(head == null){
            return head;
        }

        if(head.next == null){
            if(n==1)
                return null;
            else
                return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prevOfSlow = null;

        while(n-- > 0 && fast != null){
            fast = fast.next;
        }

        while(fast != null){
            prevOfSlow = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if(slow != head){
            prevOfSlow.next = slow.next;
            slow.next = null;
        }

        if(slow==head && fast != head){
            head = head.next;
        }

        return head;
    }
}