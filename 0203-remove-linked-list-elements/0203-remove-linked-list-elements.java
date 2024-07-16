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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;

        ListNode temp = head;
        temp=temp.next;
        ListNode prev = head;
        while(temp!=null){
            if(temp.val == val){
                ListNode t = temp;
                prev.next = temp.next;
                temp=temp.next;
                t.next = null;
                continue;
            }
            prev=temp;
            temp = temp.next;
        }

        if(head.val == val){
            ListNode t = head;
            head = head.next;
            t.next = null;
        }

        return head;
    }
}