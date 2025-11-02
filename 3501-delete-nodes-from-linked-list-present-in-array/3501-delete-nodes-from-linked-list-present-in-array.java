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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        ListNode curr = head, next=null,prev=null;

        while(curr != null){
            if(set.contains(curr.val)){
                if(curr == head){
                    next = curr.next;
                    curr.next = null;
                    head = next;
                    curr = next;
                }else{
                    next = curr.next;
                    prev.next = next;
                    curr.next = null;
                    curr = next;
                }
            }else{
                prev = curr;
                next = curr.next;
                curr = next;
            }
        }

        return head;
    }
}