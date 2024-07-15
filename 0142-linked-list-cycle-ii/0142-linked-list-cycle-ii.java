/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return head;
        Set<ListNode> set =new HashSet<>();

        //ListNode f=head;
        ListNode s=head;

        while(s!=null){
            if(set.contains(s)){
                return s;
            }
            set.add(s);
            s = s.next;
           // f=f.next.next;
        }

        return null;
    }
}