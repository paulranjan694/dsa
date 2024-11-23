/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node dummy = new Node(-1);
        Node tempdummy = dummy;
        Node temp = head;

        while(temp != null){
            Node newnode = new Node(temp.val);
            tempdummy.next = newnode;
            tempdummy = tempdummy.next;
            map.put(temp,newnode);
            temp=temp.next;
        }

        temp = head;
        Node temp1 = dummy.next;

        while(temp != null && temp1 != null){
            if(temp.random == null)
                temp1.random = null;
            else{
                temp1.random = map.get(temp.random);
            }
            temp=temp.next;
            temp1=temp1.next;
        } 

        return dummy.next;

    }
}