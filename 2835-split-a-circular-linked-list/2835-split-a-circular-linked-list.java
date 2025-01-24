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
    public ListNode[] splitCircularLinkedList(ListNode list) {
        if(list == null || list.next == null) return new ListNode[]{null, null};
        ListNode slow = list, fast = list;
        
        while(fast.next != list && fast.next.next != list){
            slow = slow.next;
            fast = fast.next.next;
        }
      
        ListNode head2 = slow.next;
        ListNode head1 = list;
        slow.next=head1;
        fast=head2;
        while(fast.next!=list){
          fast=fast.next;
        }
        fast.next=head2;
        return new ListNode[]{head1, head2}; // Return two empty lists as placeholders
    }
}
