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
    public ListNode rotateRight(ListNode head, int k) {
        if(head ==null || k==0) return head;
        ListNode temp = head;
        int len = getLength(temp);

        k = k % len;

        ListNode kth = findKthNode(temp, len-k-1);
        ListNode nextnode = kth.next;
        kth.next = null;
        ListNode rev = reverse(head);
        ListNode prev= head;
        head = rev;
        rev = reverse(nextnode);
        prev.next = rev;

        rev = reverse(head);
        return rev;
    }

    public ListNode reverse(ListNode node){
        ListNode temp = node, next=null,prev=null;

        while(temp != null){
            next = temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }

    public int getLength(ListNode tnode){
        ListNode node = tnode;
        int cnt = 0;
        while(node != null){
            cnt++;
            node = node.next;
        }
        return cnt;
    }

    public ListNode findKthNode(ListNode h, int k){
        if(h == null || k==0) return h;
        ListNode t = h;
        k--;
        while(k >= 0 && t!=null){
            t=t.next;
            k--;
        }
        return t;
    }
}