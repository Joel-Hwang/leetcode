package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.testng.annotations.Test;

public class _133_CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node res = new Node(node.val);
        Set<Integer> set = new HashSet<>();
        HashMap<Integer,Node> resMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Queue<Node> resQ = new LinkedList<>();
        q.add(node);
        resQ.add(res);
        while(!q.isEmpty()){
            Node cur = q.poll();
            Node resCur = resQ.poll();
            if(set.contains(cur.val)) continue;
            set.add(cur.val);
            resMap.put(resCur.val,resCur);

            for(Node child : cur.neighbors){
                q.add(child);
                Node resChild = null;
                if(resMap.containsKey(child.val))
                    resChild = resMap.get(child.val);
                else{
                    resChild = new Node(child.val);
                    resMap.put(child.val,resChild);
                }

                resCur.neighbors.add(resChild);
                resQ.add(resChild);
            }
        }
        
        
        return res;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    @Test
    public void test(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        cloneGraph(n1);
    }
}
