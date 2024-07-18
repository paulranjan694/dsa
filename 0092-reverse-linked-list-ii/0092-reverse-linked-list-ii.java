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
        if(head == null || head.next == null || (left ==1 && right==1)) return head;
        
        ListNode temp = head;
        ListNode leftPrev = null;
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
        
        ListNode leftNext = null;
        if(leftPrev==null)
            leftNext = head;
        else
            leftNext = leftPrev.next;
        
        ListNode rightNext = null;
        if(rightPrev == null){
            rightNext = head;
        }else{
            rightNext = rightPrev.next;
        }
        if(leftPrev != null)
            leftPrev.next = null;
        
        if(rightPrev!=null)
            rightPrev.next = null;

        ListNode revHead = reverse(leftNext);
        if(leftPrev != null)
            leftPrev.next = revHead;
        else 
            head = revHead;
        
        leftNext.next = rightNext;
        return head;
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