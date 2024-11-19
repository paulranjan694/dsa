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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h1 = list1;
        ListNode h2 = list2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode t = null;
        while(h1!=null && h2!=null){
            if(h1.val >= h2.val){
                t = new ListNode(h2.val);
                h2 = h2.next;
            }else if(h1.val < h2.val){
                t = new ListNode(h1.val);
                h1 = h1.next;
            }
            temp.next = t;
            temp=temp.next;
        }

        while(h1!=null){
            t = new ListNode(h1.val);
            temp.next = t;
            temp=temp.next;
            h1 = h1.next;
        }

        while(h2!=null){
            t = new ListNode(h2.val);
            temp.next = t;
            temp=temp.next;
            h2 = h2.next;
        }

        return dummy.next;
    }
}