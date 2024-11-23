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
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode prev=null, next =null, tempHead = head, temp = head;

       while(temp != null){
            ListNode kth = findKthNode(temp,k);
            if(kth != null){
                next = kth.next;
                kth.next=null;
                ListNode revhead = reverse(tempHead);

                if(tempHead == head){
                    head = revhead;  
                }else{
                    prev.next = revhead;
                }
                prev = tempHead;
                tempHead.next = next;
                tempHead = next;
            }
            temp = temp.next;
       }
       return head;
    }

    public ListNode reverse(ListNode node){
        ListNode prev=null, next =null, temp = node;

        while(temp!=null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    } 

    public ListNode findKthNode(ListNode h, int k){
        if(h == null || k==0) return h;
        ListNode t = h;
        k--;
        while(k > 0 && t!=null){
            t=t.next;
            k--;
        }
        return t;
    }
}