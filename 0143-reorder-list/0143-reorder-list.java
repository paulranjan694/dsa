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
    public void reorderList(ListNode head) {
        if(head == null || head.next==null) return;
        ListNode slow=head,fast=head,prev=null;
        while(fast!= null && fast.next !=null){
            fast = fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        
        ListNode mid = slow;
        fast=mid;
        prev.next=null;
        while(fast.next!=null){
            fast=fast.next;
        }
        
        reverse(mid);

        ListNode h1 = head, h2 = fast,prevh1=null;
        while(h1!=null && h2 != null){
            ListNode h1next = h1.next;
            ListNode h2next = h2.next;

            h1.next = h2;
            prevh1=h2;
            h2.next=h1next;
            h1=h1next;
            h2=h2next;

        }
        if(h2!=null){
            prevh1.next=h2;
        }
        
    }

    public ListNode reverse(ListNode head){
        if(head==null) return head;
        
        ListNode curr=head, prev=null,next=null;
        
        while(curr != null){
            next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}