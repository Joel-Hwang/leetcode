package Medium;
import java.util.*;

public class MaximumTree {
    public MaximumTree(){
        Node _5 = new Node(5);
        Node _6 = new Node(6);
        List<Node> _dep3 = new ArrayList<Node>();
        _dep3.add(_5);
        _dep3.add(_6);
        Node _3 = new Node(3, _dep3);
        Node _2 = new Node(2);
        Node _4 = new Node(4);
        List<Node> _dep2 = new ArrayList<Node>();
        _dep2.add(_3);
        _dep2.add(_2);
        _dep2.add(_4);
        Node _1 = new Node(1, _dep2);
        System.out.println(maxDepth(_1));
    }

    public int maxDepth(Node root) {
        if(root == null) return 0;
        return getDepth(root, 1);
    }

    private int getDepth(Node node, int nodeDepth){
       
        int result = 0;
        
        if(node.children == null || node.children.size() == 0){
            return nodeDepth;
        }

        for(int i = 0; i<node.children.size(); i++){
            int childDepth = getDepth(node.children.get(i),nodeDepth+1);
            result = Math.max(result, childDepth);
            
        }
        System.out.println(node.val +"  "+ nodeDepth +"  " + result);
        return result;
    }


    public int maxDepth2(Node root) {
        if (root == null) return 0;
        int depth = 1;
        if (root.children.size() == 0) {
            return depth;
        }
        int maxChildDepth = Integer.MIN_VALUE;
        for (Node c : root.children) {
            int childDepth = maxDepth(c);
            if (childDepth > maxChildDepth) {
                maxChildDepth = childDepth;
            }
        }
        return depth + maxChildDepth;
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    
};