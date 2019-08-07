
public class LRUCache {

    class Node {
        int val,key;
        Node next,prev;
    }

    Map<Integer,Node> map;
    int size,capacity;
    Node head,tail;

    public LRUCache(int capacity) {

        map = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;

        head = new Node();
        tail = new Node();
        tail.next = null;
        head.prev = null;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        // O(1) access to the element in cache
        Node node = map.get(key);

        if(node == null)
            return -1;

        // if element is accessed move it to head
        moveToHead(node);

        return node.val;
    }

    // adds a node after the head with node storing reference of that node
    public void addNode(Node node) {

        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;

    }

    public void deleteNode(Node node) {

        Node previous = node.prev;
        Node nxt = node.next;

        previous.next = nxt;
        nxt.prev = previous;

    }

    private void moveToHead(Node node){
        deleteNode(node);
        addNode(node);
    }

    public Node popTail() {
        Node element = tail.prev;
        deleteNode(element);
        return element;
    }

    public void put(int key, int value) {

        Node node = map.get(key);

        // item not in cache
        if(node == null) {

            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            map.put(key, newNode);
            addNode(newNode); // adds it after head node

            this.size++;

            if(this.size > capacity) {
                // cache eviction required buffer size is full exceeds capacity
                Node temp = popTail();
                map.remove(temp.key);
                --size;
            }
        } else {
        // item in cache move it to head;

            node.val = value;
            moveToHead(node);

        }



    }

}
