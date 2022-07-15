package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.testng.annotations.Test;

public class _2050_ParallelCoursesIII {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, Node> map = getNodeMap(n,time);
        setRelation(map, relations);
        List<Node> starts = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key).children.size() == 0 && map.get(key).parents.size() > 0)
                starts.add(map.get(key));
        }

        Queue<Node> q = new LinkedList<>();
        for(Node start : starts) q.add(start);
        if(q.isEmpty()) q.add(map.get(1));

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node parent : cur.parents){
                if(map.keySet().contains(parent.val) == false) continue;
                parent.cost = Math.max(parent.cost, cur.cost + parent.month);
                parent.children.remove(cur);
                if(parent.children.size() ==0 && parent.parents.size() > 0  ) 
                    q.add(parent);
            }

            for(Node parent : cur.parents)
                if(map.keySet().contains(parent.val) )
                    map.remove(cur.val);
            
        }

        int res = 0;
        for(int key : map.keySet()){
            res = Math.max(res,map.get(key).cost);
        }
        return res;
        
    }

    private Map<Integer,Node> getNodeMap(int n, int[] time){
        Map<Integer, Node> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            Node node = new Node(i+1, time[i]);
            map.put((i+1), node);
        }
        return map; 
    }

    private void setRelation(Map<Integer, Node> map, int[][] relations){
        for(int[] rel : relations) {
            Node parent = map.get(rel[1]);
            Node child = map.get(rel[0]);
            parent.children.add(child);
            child.parents.add(parent);
        }
    }

    class Node{
        int val;
        int month;
        public int cost;
        public Set<Node> children;
        public Set<Node> parents;
        public Node(int val, int month){
            this.val = val;
            this.cost = month;
            this.month = month;
            children = new HashSet<Node>();
            parents = new HashSet<Node>();
        }
    }
    @Test
    public void test(){

        assertEquals(5, minimumTime(2, new int[0][0], new int[]{3,5}));
        assertEquals(32, minimumTime(9, new int[][]{{2,7},{2,6},{3,6},{4,6},{7,6},{2,1},{3,1},
                                                                {4,1},{6,1},{7,1},{3,8},{5,8},{7,8},{1,9},{2,9},{6,9},{7,9}}, new int[]{9,5,9,5,8,7,7,8,4}));
        assertEquals(3, minimumTime(2, new int[][]{{1,2},{2,1}}, new int[]{1,2}));
        assertEquals(1, minimumTime(1, new int[0][0], new int[]{1}));
        
        assertEquals(12,minimumTime(5, new int[][]{{1,5},{2,5},{3,5},{3,4},{4,5}}, new int[]{1,2,3,4,5}));
    }
}
