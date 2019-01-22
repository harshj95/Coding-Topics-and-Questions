package datastructures;

public class LinkedList {

    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void traverseList() {
        Node node = head;

        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public Node findElement(int data) {
        Node node = head;

        while (node != null) {
            if (node.data == data)
                return node;

            node = node.next;
        }

        return null;
    }

    public void deleteUsingValue(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = null;
        } else {
            Node current = head;

            while (current.next != null) {
                if (current.next.data == data) {
                    current.next = current.next.next;
                    return;
                }
            }
        }
    }
}
