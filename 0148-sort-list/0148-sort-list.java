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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode middle = findMiddle(temp);

        ListNode leftHead = temp;
        ListNode rightHead = middle.next;
        middle.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        ListNode mergeHead = merge2LL(leftHead,rightHead);
        return mergeHead;
    }

    public ListNode findMiddle(ListNode h){
        if(h == null || h.next == null) return h;

        ListNode slow = h;
        ListNode fast = h.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge2LL(ListNode h1, ListNode h2){
        if(h1 == null && h2 == null) return null;
        
        ListNode t1 = h1;
        ListNode t2 = h2;
        ListNode d = new ListNode(-1);
        ListNode dt = d;
        
        while(t1!=null && t2!=null){
            if(t1.val < t2.val){
                ListNode nd = new ListNode(t1.val);
                dt.next = nd;
                dt = dt.next;
                t1=t1.next;
            }else if(t1.val > t2.val){
                ListNode nd = new ListNode(t2.val);
                dt.next = nd;
                dt = dt.next;
                t2=t2.next;
            }else{
                ListNode nd = new ListNode(t2.val);
                dt.next = nd;
                dt = dt.next;
                t2=t2.next;
            }
        }
        
        while(t1!=null){
            ListNode nd = new ListNode(t1.val);
            dt.next = nd;
            dt = dt.next;
            t1=t1.next;
        }
        
        while(t2!=null){
            ListNode nd = new ListNode(t2.val);
            dt.next = nd;
            dt = dt.next;
            t2=t2.next;
        }
        return d.next;
    }
}