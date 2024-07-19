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

 //tc - nlogk - divide and conquer , sc - o(1)
//tc - nk - merge list one-by-one, sc - o(1)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        int interval = 1;
        while(interval < len){
            for(int i=0;i<len-interval;i += 2*interval){
                lists[i] = merge2LL(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return len > 0 ? lists[0] : null;
        //return mergeHelper(lists[0],0,len,lists);
    }

    public ListNode mergeHelper(ListNode h, int idx, int len, ListNode[] lists){
        if(len-1==idx){
            return h;
        }

        ListNode returnedHead = mergeHelper(lists[idx+1], idx+1,len, lists);
        ListNode mergedLLHead = merge2LL(returnedHead,h);
        return mergedLLHead; 
    }

    ListNode merge2LL(ListNode h1, ListNode h2){
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