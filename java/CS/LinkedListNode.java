package CS;

public class LinkedListNode {
    Node header;

    static class Node {
        int data;
        Node next;
        public Node(){}
        public Node(int d){
            this.data = d;
        }
    }

    public LinkedListNode() {
        header = new Node();
    }

    public void append(int d) {
        Node end = new Node(d);
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int d) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data); // last node
    }
}
