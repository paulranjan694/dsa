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

        while(n-- > 0 && fast != null){
            fast = fast.next;
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        if(fast == null){
            ListNode t = head;
            head = head.next;
            t.next = null;
            return head;
        }
        
        ListNode t = slow.next;
        slow.next = slow.next.next;
        t.next = null;
        return head;
    }
}