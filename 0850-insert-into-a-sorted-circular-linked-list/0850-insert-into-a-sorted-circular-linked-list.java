/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
            Node temp = head;

            Node node = new Node(insertVal);
            if(temp==null){
                  node.next=node;
                  head = node;
            }

            while(temp !=null && temp.next!=head){
                if(temp.val <= insertVal && insertVal <= temp.next.val){
                    node.next = temp.next;
                    temp.next = node;
                    return head;
                }else if(temp.val>temp.next.val){
                    if(temp.val<=insertVal || insertVal<=temp.next.val){
                        node.next=temp.next;
                        temp.next=node;
                        return head;
                    }
                }
                temp=temp.next;
            }
            if(temp !=null){
                node.next = temp.next;
                temp.next = node;
            }
            return head;
    }
}