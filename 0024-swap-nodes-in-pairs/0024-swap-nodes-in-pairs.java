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
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null){
            swap(curr,curr.next);
            curr = curr.next.next;
        }
        return head;
    }

    public void swap(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}