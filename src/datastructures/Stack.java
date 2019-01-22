package datastructures;

import java.util.EmptyStackException;

public class Stack {

    private Node top;
    int data;

    public int pop() {
        if (top == null)
            throw new EmptyStackException();

        int item = top.data;
        top = top.next;
        return item;
    }

    public Node push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;

        return top;
    }

    public int peek() {
        if (top == null)
            throw new EmptyStackException();

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
