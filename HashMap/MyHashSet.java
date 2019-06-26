public class MyHashSet {

    private final Node[] list;
    /** Initialize your data structure here. */
    public MyHashSet() {
        list = new Node[10000];
    }

    public int idx(int key) {
        return Integer.hashCode(key) % list.length;
    }

    public void add(int key) {

    int idx = idx(key);

    if(list[idx] == null)
        list[idx] = new Node(-1,true);

    Node prev = null;
    Node current = list[idx];

    while (current!=null && current.key!=key)
    {
        prev = current;
        current =current.next;
    }

    if(current == null)
        prev.next = new Node(key,true);

    }

    public void remove(int key) {

        int idx = idx(key);
        if(list[idx] == null)
            return;

        Node prev = null;
        Node current = list[idx];

        while (current!=null && current.key!=key)
        {
            prev = current;
            current =current.next;
        }

        if(current == null)
        return;

        prev.next = current.next;
        current.next = null;
        current =null;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        int idx = idx(key);
        if(list[idx] == null)
            return false;

        Node prev = null;
        Node current = list[idx];

        while (current!=null && current.key!=key)
        {
            prev = current;
            current =current.next;
        }

        return current == null ? false : true;

    }
}

class Node {

    Node next;
    int key;
    boolean val;

    public Node(int key,boolean val) {
        this.key = key;
        this.val = val;
    }

}
