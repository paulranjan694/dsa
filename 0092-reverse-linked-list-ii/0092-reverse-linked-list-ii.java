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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = null, rightNode = null,leftPrev = null, rightNext = null, curr=head;
        int count=1;
        while(curr != null){
            if(count == left){
                leftNode = curr;
            }

            if(count == left-1){
                leftPrev = curr;
            }

            if(count==right){
                rightNode = curr;
            }
            curr= curr.next;
            count++;
        }

        if(rightNode != null){
            rightNext = rightNode.next;
            rightNode.next = null;
        }
        if(leftPrev != null)
            leftPrev.next = null;
        ListNode tempHead = reverse(leftNode);
        if(leftPrev != null){
            leftPrev.next=tempHead;
        }else{
            head=tempHead;
        }
        if(leftNode != null)
            leftNode.next = rightNext;
        return head;
    }

    private ListNode reverse(ListNode h){
        if(h == null || h.next == null){
            return h;
        }

        ListNode prev = null,next=null;
        while(h != null){
            next = h.next;
            h.next=prev;
            prev = h;
            h=next;
        }

        return prev;
    }
}