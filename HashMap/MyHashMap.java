class MyHashMap {


    private final ListNode[] list;
    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new ListNode[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        // find bucket for this key
        int idx = this.idx(key);

        // if bucket has an empty linked list just add a dummy node
        if(list[idx] == null)
            list[idx] = new ListNode(-1,-1 );

        // find the previous node after which you would insert an element in the chain
        ListNode prev = find(list[idx],key);
        // key doesn't exist before so you would append it to the chain
        if(prev.next == null)
            prev.next = new ListNode(key,value);
        else
            prev.next.val = value; // this is the update condition
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int idx = this.idx(key);

        if(list[idx] == null)
        return -1;

        ListNode current = list[idx];

        while(current!=null && current.key!=key)
        {
            current = current.next;
        }

        return (current==null) ? -1 : current.val;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        int idx = this.idx(key);

        if(list[idx] == null)
            return ;

        ListNode current = list[idx];
        ListNode prev = null;
        
        while (current!=null && current.key!=key) {
            prev = current;
            current = current.next;
        }

        if(current==null)return;
        prev.next = current.next;
        current.next = null;
        current = null;
        
        
    }

    ListNode find(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    int idx(int key) { return Integer.hashCode(key) % list.length;}

}



class ListNode {
    int key, val;
    ListNode next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
