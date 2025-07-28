class LRUCache {

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head,tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            deleteNode(node);
            addNodeToMRU(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
       if(cache.containsKey(key)){
            Node node = cache.get(key);
            deleteNode(node);
            addNodeToMRU(node);
            node.value = value;
            cache.put(key,node);
        }else{
            if(cache.size() >= capacity){
                Node lruNode = tail.prev;
                deleteNode(lruNode);
                cache.remove(lruNode.key);
                lruNode.key = key;
                lruNode.value = value;
                addNodeToMRU(lruNode);
                cache.put(key,lruNode);
            }else{
                Node node = new Node(key,value);
                addNodeToMRU(node);
                cache.put(key,node);
            }
        }
    }

    private void deleteNode(Node node){
        Node tPrev = node.prev;
        Node tNext = node.next;
        tPrev.next = node.next;
        tNext.prev = node.prev;
        node.next = null;
        node.prev=null;
        
    }

    private void addNodeToMRU(Node node){
        Node tnode = head.next;
        node.next = tnode;
        node.prev = head;
        if(tnode != null)
            tnode.prev=node;
        head.next = node;
    }
}

class Node{
    int key, value;
    Node next,prev;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next=null;
        this.prev=null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */