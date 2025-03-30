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
    public boolean isPalindrome(ListNode head) {
        if(head != null && head.next == null) return true;
        ListNode fast=head,slow=head,prev=null,next=null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        if(prev == null) return false;
        ListNode mid=slow;
        prev.next=null;
        prev = null;
        ListNode temp = mid;
        while(temp!= null){
           next = temp.next;
           temp.next=prev;
           prev=temp;
           temp=next;
        }
        ListNode h1=head,h2=prev;
        while(h1 != null && h2 != null){
            if(h1.val != h2.val){
                return false;
            }
            h1=h1.next;
            h2=h2.next;
        }
        return true;


    }
}