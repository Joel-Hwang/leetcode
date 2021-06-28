package Easy;

import java.util.LinkedList;

import org.testng.annotations.Test;

public class _155_MinStack {
    class MinStack {
        LinkedList<Integer> ll;

        /** initialize your data structure here. */
        public MinStack() {
            ll = new LinkedList<>();
        }

        public void push(int val) {
            ll.add(0, val);
        }

        public void pop() {
            ll.remove(0);
        }

        public int top() {
            return ll.getFirst();
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            for (int i : ll) {
                if (i < min)
                    min = i;
            }
            return min;
        }
    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top(); // return 0
        minStack.getMin(); // return -2
    }
}
