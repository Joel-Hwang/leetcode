package Easy;

import java.util.LinkedList;
import java.util.Queue;

import org.testng.annotations.Test;

public class _225_ImplementStackUsingQueues {
    class MyStack {
        Queue<Integer> q;
        int top;
        public MyStack() {
            q = new LinkedList<Integer>();
        }
        
        public void push(int x) {
            q.add(x);
            top = x;

        }
        
        public int pop() {
            Queue<Integer> q2 = new LinkedList<Integer>();
            int res = 0;
            while(!q.isEmpty()){
                res = q.poll();
                if(q.isEmpty()) break;
                q2.add(res);
                top = res;
                
            }
            q = q2;
            return res;
        }
        
        public int top() {
            if(empty()) throw new IllegalStateException();
            return top;
        }
        
        public boolean empty() {
            return q.isEmpty();
        }
    }

    @Test
    public void test(){
        MyStack stk = new MyStack();
        stk.push(1);
        System.out.println(stk.pop());
        System.out.println(stk.empty());
    }
}
