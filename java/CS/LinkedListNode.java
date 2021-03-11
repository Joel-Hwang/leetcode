package CS;

import java.util.HashMap;

public class LinkedListNode {
    public Node header;

    public static class Node {
        public int data;
        public Node next;

        public Node() {
        }

        public Node(int d) {
            this.data = d;
        }

        public int getData() {
            return data;
        }
    }

    static class Reference {
        int count;

        Reference(int count) {
            this.count = count;
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
    public void removeDups() {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Node n = header;
        while (n.next != null) {
            if (hm.get(n.next.data) == null) {
                hm.put(n.next.data, 0);
                n = n.next;
            } else {
                n.next = n.next.next;
            }
        }
    }

    // TIme, Space O(n2), O(1)
    public void removeDups2() {
        Node n = header.next;
        while (n != null && n.next != null) {
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;

        }
    }

    // 전체 노드 카운트 후 처음부터 count-key+1로 다시
    // Time, Space O(n2), O(1)
    public Node kthLast(Node first, int key) {

        Node n = new Node();
        n.next = first;
        int cnt = 0;
        while (n.next != null) {
            cnt++;
            n = n.next;
        }

        n = new Node();
        n.next = first;
        for (int i = 0; i < cnt - key; i++) {
            n = n.next;
        }
        return n;
    }

    public Node kthLast2(Node first, int key) {
        return kthLast2(first.next, key, new Reference(0));
    }

    private Node kthLast2(Node n, int k, Reference r) {
        if (n == null)
            return null;
        Node found = kthLast2(n.next, k, r);
        r.count++;
        if (r.count == k)
            return n;
        return found;
    }

    public Node kthLast3(Node first, int key) {
        Node c = first;
        Node nth = first;
        for (int i = 0; i < key; i++) {
            nth = nth.next;
        }

        while (c.next != null) {
            if (nth == null)
                break;
            c = c.next;
            nth = nth.next;
        }

        return c;
    }

    public void deleteNode(Node n) {
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
    }

    public Node addReverse(Node l1, Node l2) {
        Node cl1 = l1;
        Node cl2 = l2;
        String a = "" + cl1.data;
        String b = "" + cl2.data;
        while (cl1.next != null) {
            a = cl1.next.data + a;
            cl1 = cl1.next;
        }
        while (cl2.next != null) {
            b = cl2.next.data + b;
            cl2 = cl2.next;
        }

        String c = "" + (Integer.parseInt(a) + Integer.parseInt(b));
        
        Node res = new Node( );
        Node cRes = res;
        for(int i = c.length()-1; i>=0; i--){
            cRes.next = new Node(Integer.parseInt(c.charAt(i)+""));
            cRes = cRes.next;
        }
        return res.next;
    }

    public Node addReverse2(Node l1, Node l2, int c){
        if(l1 == null && l2 == null && c == 0) return null;
        int value = c;
        if(l1 != null){
            value += l1.data;
        }
        if(l2 != null){
            value += l2.data;
        }
        
        Node result = new Node(value%10);
        result.next = addReverse2(l1==null?null:l1.next, l2==null?null:l2.next, value/10);

        return result;
    }

}
