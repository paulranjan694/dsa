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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1 == null) return null;

        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode tail2 = list2;
        ListNode t1 = null;
        ListNode t2 = null;
        
        int count=0;
        while(head1 != null){
            if(count == a-1){
                t1 = head1;
            }

            if(count == b+1){
                t2=head1;
            }
            count++;
            head1=head1.next;
        }

        while(tail2 != null && tail2.next != null){
            tail2 = tail2.next;
        }

        t1.next = head2;
        tail2.next = t2;

        return list1;

    }
}