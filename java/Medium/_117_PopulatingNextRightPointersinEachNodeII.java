package Medium;

import java.util.LinkedList;
import java.util.Queue;

import org.testng.annotations.Test;


public class _117_PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Node node = q.poll();
                if(i<size-1) node.next = q.peek();
                if(node.left!= null)
                    q.add(node.left);
                if(node.right!= null)
                    q.add(node.right);
            }
        }

        return root;
    }

    @Test
    public void test(){
        Node ll = new Node(4);
        Node lr = new Node(5);
        Node rr = new Node(7);
        Node l = new Node(2);
        Node r = new Node(3);
        Node root = new Node(1);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.right = rr;
        Node result = connect(root);
        System.out.println(result.val);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

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
