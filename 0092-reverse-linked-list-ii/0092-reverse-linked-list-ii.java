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

 /**
  * using dummy node concept
  */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = head;
        ListNode leftPrev = dummy;
        ListNode rightPrev = null;
        int count=1;
        while(temp!=null){
            if(count < left){
                leftPrev=temp;
            }

            if(count<=right){
                rightPrev=temp;
            }
            count++;
            temp = temp.next;
        }
        
        ListNode leftNext = leftPrev.next;
        ListNode rightNext = rightPrev.next;
        leftPrev.next = null;
        rightPrev.next = null;

        ListNode revHead = reverse(leftNext);
        leftPrev.next = revHead;
        leftNext.next = rightNext;

        return dummy.next;
    }

    public ListNode reverse(ListNode h){
        if(h==null) return h;

        ListNode p = null;
        ListNode t = h;

        while(t!=null){
            ListNode x = t.next;
            t.next = p;
            p=t;
            t=x;
        }
        h=p;
        return h;
    }
}