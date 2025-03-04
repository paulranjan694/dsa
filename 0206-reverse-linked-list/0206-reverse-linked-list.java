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
    public ListNode reverseList2(ListNode head) {
        if(head == null) return head;

        ListNode prev=null, curr = head,next=null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        return prev;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null) return head;

        ListNode rNode = reverseList(head.next);
        ListNode f = head.next;
        f.next = head;
        head.next = null;
        return rNode;
    }

}