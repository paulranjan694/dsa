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
        if(head==null) return head;

        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while(temp!=null){
            ListNode kth = findKthNode(temp,k);
            if(kth != null){
                nextNode = kth.next;
                kth.next = null;
                ListNode revHead = reverse(temp);
                if(temp == head){
                    head = revHead;
                    prevNode = temp;
                }else{
                prevNode.next = revHead;
                prevNode = temp;
                }
            }
            if(kth!=null)
                temp=nextNode;
            else{
                prevNode.next = temp;
                prevNode = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    public ListNode reverse(ListNode h){
        if(h==null) return h;

        ListNode p = null;
        ListNode t = h;

        while(t!=null){
            ListNode x = t.next;
            t.next = p;
            p=t;
            t=x;
        }
        h=p;
        return h;
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