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
        if(head == null) return head;

        ListNode temp = head;
        int len = lengthOfLL(temp);
        k = k % len;

        if(k==0) return head;

        ListNode fast = temp;
        ListNode slow = temp;

        while(k-- > 0 && fast != null){
            fast = fast.next;
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode nextNode = slow.next;
        slow.next = null;
        fast.next = temp;
        head = nextNode;




        // if(fast==null){
        //     ListNode revHead = reverse(temp);
        //     head = revHead;
        // }else{
        //     ListNode nextNode = slow.next;
        //     slow.next = null;
        //     ListNode h1 = reverse(temp);
        //     ListNode h2 = reverse(nextNode);
        //     temp.next = h2;
        //     ListNode h3 = reverse(h1);
        //     head = h3;
        // }
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


    public int lengthOfLL(ListNode h){
        if(h==null) return 0;

        ListNode t = h;
        int len=0;
        while(t != null){
            t=t.next;
            len++;
        }

        return len;
    }
}