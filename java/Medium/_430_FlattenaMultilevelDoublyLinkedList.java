package Medium;

import java.util.ArrayList;

public class _430_FlattenaMultilevelDoublyLinkedList {
    ArrayList<Node> list = new ArrayList<>();
    public Node flatten(Node head) {
        if(head == null) return null;
        rec(head);

        list.get(0).child = null;
        for(int i = 1; i<list.size(); i++){
            list.get(i-1).next = list.get(i);
            list.get(i).prev = list.get(i-1);
            list.get(i).child = null;
        }
        return list.get(0);
    }
    private void rec(Node node){
        if(node == null) return;
        list.add(node);
        rec(node.child);
        rec(node.next);

    }



    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
