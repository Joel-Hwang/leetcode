package CS;

import java.util.HashMap;

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

    // Time,Space O(n),O(n)
    public void removeDups(){
        HashMap<Integer,Integer> hm = new HashMap<>();
        Node n = header;
        while(n.next != null){
            if(hm.get(n.next.data) == null){
                hm.put(n.next.data, 0);
                n = n.next;
            }else{
                n.next = n.next.next;
            }
        }
    }

    // TIme, Space O(n2), O(1)
    public void removeDups2(){
        Node n = header.next;
        while(n!= null && n.next != null){
            Node r = n;
            while(r.next != null){
                if(n.data == r.next.data){
                    r.next = r.next.next;
                }else{
                    r = r.next;
                }
            }
            n = n.next;

        }
    }

    //전체 노드 카운트 후 처음부터 count-key+1로 다시
    public Node kthLast(Node first, int key){
        return null;
    }
}
