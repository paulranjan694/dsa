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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode curr = head,prev=null;
        ListNode[] res = new ListNode[k];

        while(curr != null){
            len++;
            prev = curr;
            curr=curr.next;
        }

        if(len <= k){
            curr=head;
            ListNode next=null;
            int index=0;
            while(curr!= null){
                next = curr.next;
                curr.next=null;
                res[index++] = curr;
                curr = next;
            }
        }else{
            int groups = len/k;
            int rem = len % k;
            curr=head;
            ListNode next=null;
            for(int i=0;i<k;i++){
                int temp =groups;
                ListNode thead = new ListNode(-1);
                ListNode tail = thead;
                while(curr != null && temp-- >0){
                    ListNode t = new ListNode(curr.val);
                    tail.next=t;
                    tail=tail.next;
                    curr = curr.next;
                }
                if(rem > 0 && curr != null){
                    ListNode t = new ListNode(curr.val);
                    tail.next=t;
                    tail=tail.next;
                    curr = curr.next;
                    rem--;
                }
                if(curr!=null){
                    next = curr;
                    curr=null;
                }
                res[i] = thead.next;
                curr=next;
            }
        }

        return res;

    }
}