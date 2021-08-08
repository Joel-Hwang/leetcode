package Medium;

import java.util.ArrayList;

import org.testng.annotations.Test;


public class _116_PopulatingNextRightPointersEachNode {
    //4 ms, faster than 8.81%
    public Node connect2(Node root) {
        if(root == null) return null;
        ArrayList<Node> q = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            //link same levels
            for(int i = 0; i<size-1; i++){
                q.get(i).next = q.get(i+1);
            }
            //add childrens and remove parents
            for(int i = 0; i<size; i++){
                if(q.get(0).left != null)
                    q.add(q.get(0).left);
                if(q.get(0).right != null)
                    q.add(q.get(0).right);
                q.remove(0);
            }
        }
        return root;
    }
    //Runtime: 0 ms, faster than 100.00% of Ja
    public Node connect(Node root){
        if(root == null) return null;
        if(root.left == null) return root;
        root.left.next = root.right;
        root.right.next = (root.next == null?null:root.next.left);
        connect(root.left);
        connect(root.right);

        return root;
    }

    @Test
    public void test(){
        Node root = new Node(1);
        Node L = new Node(2);
        Node R = new Node(3);
        Node LL = new Node(4);
        Node LR = new Node(5);
        Node RL = new Node(6);
        Node RR = new Node(7);
        // L.left = LL;
        // L.right = LR;
        // R.left = RL;
        // R.right = RR;
        // root.left = L;
        // root.right = R;
        Node result = connect(root);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}

