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
        if(list1 == null && list2 == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode h1 = list1;
        ListNode h2 = list2;
        ListNode temp = dummy;

        while(h1 != null || h2 != null){
            if(h1 != null && h2 != null){
                if(h1.val > h2.val){
                    ListNode node = new ListNode(h2.val);
                    temp.next = node;
                    temp = temp.next;
                    h2 = h2.next;
                }else if(h1.val < h2.val){
                    ListNode node = new ListNode(h1.val);
                    temp.next = node;
                    temp = temp.next;
                    h1 = h1.next;
                }else{
                    ListNode node = new ListNode(h1.val);
                    temp.next = node;
                    temp = temp.next;
                    h1 = h1.next;
                    ListNode node1 = new ListNode(h2.val);
                    temp.next = node1;
                    temp = temp.next;
                    h2 = h2.next;
                }
            }else if(h1 != null){
                    ListNode node = new ListNode(h1.val);
                    temp.next = node;
                    temp = temp.next;
                    h1 = h1.next;
            }else if(h2 != null){
                    ListNode node1 = new ListNode(h2.val);
                    temp.next = node1;
                    temp = temp.next;
                    h2 = h2.next;
            }
        }

        return dummy.next;
    }
}