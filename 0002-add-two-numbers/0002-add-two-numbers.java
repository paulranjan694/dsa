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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy,t=null;

        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum /10;
            int r = sum%10;
            t = new ListNode(r);
            temp.next = t;
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1 != null){
            int sum = l1.val + carry;
            carry = sum /10;
            int r = sum%10;
            t = new ListNode(r);
            temp.next = t;
            temp=temp.next;
            l1=l1.next;
        }
       
        while(l2 != null){
            int sum = l2.val + carry;
            carry = sum /10;
            int r = sum%10;
            t = new ListNode(r);
            temp.next = t;
            temp=temp.next;
            l2=l2.next;
        }

        if(carry > 0){
            t = new ListNode(carry);
            temp.next = t;
            temp=temp.next;
        }

        return dummy.next;

    }
}