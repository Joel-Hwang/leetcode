package Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import org.testng.annotations.Test;

public class _895_MaximumFrequencyStack {
    class FreqStack {
        Map<Integer, Node> map;
        PriorityQueue<Node> pq;
        int order = 0;
        public FreqStack() {
            map = new HashMap<>();
            pq = new PriorityQueue<>((Node n1, Node n2)->{
                int gap = n2.freq - n1.freq;    
                if(gap == 0) return n2.stk.peek() - n1.stk.peek();
                return gap;
            });
        }
        
        public void push(int val) {
            order++;
            if(map.containsKey(val)){
                map.get(val).stk.push(order);
                map.get(val).freq++;
                pq.remove(map.get(val));
                pq.add(map.get(val));
            }else{
                Node node = new Node(val);
                node.stk.push(order);
                map.put(val, node);
                pq.add(node);
            }
        }
        
        public int pop() {
            Node node = pq.poll();
            node.freq--;
            node.stk.pop();
            pq.remove(node);
            if(node.stk.size() >0) pq.add(node);
            return node.value;
            //reorder needs
        }
    }

    class Node{
        int value;
        public int freq = 0;
        public Stack<Integer> stk;
        public Node(int value ){
            this.value = value;
            freq = 1;
            stk = new Stack<>();
        }
    }

    @Test
    public void test(){
        FreqStack stk = new FreqStack();
        String[] orders = {"push","push","push","push","push","push","pop","push","pop","push","pop","push","pop","push","pop","pop","pop","pop","pop","pop"};
        int[] vals = {4,0,9,3,4,2,6,1,1,4};
        int i = 0;
        for(String order : orders){
            if("push".equals(order))
                stk.push(vals[i++]);
            else
                System.out.println(stk.pop());
        }

    }
}
