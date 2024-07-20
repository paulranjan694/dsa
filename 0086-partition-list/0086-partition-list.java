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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;

        ListNode small = new ListNode(-1);
        ListNode smallTemp = small;
        ListNode large = new ListNode(-1);
        ListNode largeTemp = large;

        ListNode temp = head;

        while(temp != null ){
        ListNode t = temp.next;
        if(temp.val < x){
            smallTemp.next = temp;
            temp.next=null;
            smallTemp = smallTemp.next;
        }else{
            largeTemp.next = temp;
            temp.next=null;
            largeTemp = largeTemp.next;
        }

        temp = t;
        }

        if(small.next == null){
            small.next = large.next;
        }else{
            smallTemp.next = large.next;
        }
    
        return small.next;
    }
}