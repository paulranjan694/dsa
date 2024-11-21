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
        ListNode midNode = middle(head);

        ListNode revHead = reverse(midNode.next);
        ListNode startHead = head;
        while(revHead != null){
            if(startHead.val != revHead.val){
                return false;
            }
            startHead = startHead.next;            
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

    public ListNode middle(ListNode head){
        ListNode slow = head, fast = head;

        while(fast!=null && fast.next != null && fast.next.next != null){
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }
}