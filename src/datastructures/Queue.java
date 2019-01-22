package datastructures;

import java.util.NoSuchElementException;

public class Queue {

    Node front;
    Node back;

    public boolean isEmpty() {
        return front == null;
    }

    public int peek() {
        if (front == null)
            throw new NoSuchElementException();

        return front.data;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (back != null)
            back.next = node;

        back = node;
        if (front == null) {
            front = node;
        }
    }

    public int remove() {
        int data = front.data;
        front = front.next;
        if (front == null)
            back = null;

        return data;
    }
}
