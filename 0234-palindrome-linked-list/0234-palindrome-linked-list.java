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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHead = reverse(slow.next);
        ListNode temp = head;
        while(revHead !=null){
            if(temp.val != revHead.val){
                return false;
            }

            temp = temp.next;
            revHead = revHead.next;
        }
        return true;

    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode t = temp.next;
            temp.next = prev;
            prev=temp;
            temp=t;
        }
        head = prev;
        return head;
    }
}