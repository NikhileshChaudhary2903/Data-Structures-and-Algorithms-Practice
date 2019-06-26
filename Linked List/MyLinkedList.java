package com.company;

public class MyLinkedList {

    LinkedListNode head,tail;
    int size = 0;
    /** Initialize your data structure here. */
    public MyLinkedList() {

        head = new LinkedListNode(0);
        tail = new LinkedListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        if (index < 0 || index >= size) return -1;

        LinkedListNode curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.value;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }


    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if(index < 0 || index > size) return;

        LinkedListNode current = head;

        for(int i = 0;i < index;i++) {
            current = current.next;
        }

        LinkedListNode newNode = new LinkedListNode(val);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if(index < 0 || index >= size) return;

        LinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        LinkedListNode temp = curr.next;
        curr.next = temp.next;
        temp.next.prev = curr;
        temp.next = null;
        temp.prev = null;
        temp = null;
        size--;
    }
}

class LinkedListNode {

    int value;
    LinkedListNode next,prev;

    public LinkedListNode(int value)
    {
        this.value = value;
    }

}
