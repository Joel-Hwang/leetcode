package Easy;

import org.testng.annotations.Test;

public class _155_MinStack {
    class MinStack {
        Node head;

        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int val) {
            Node nd = new Node(val);

            if (head == null) {
                head = nd;
                head.min = val;
            } else {
                nd.next = head;
                nd.min = Math.min(head.min, val);
                head = nd;
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

    class Node {
        public int val;
        public Node next;
        public int min;

        public Node() {
        }

        public Node(int d) {
            this.val = d;
        }

        public Node(int d, int min, Node next) {
            this.val = d;
            this.min = min;
            this.next = next;
        }

    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top(); // return 0
        minStack.getMin(); // return -2
        /*
         * MinStack minStack = new MinStack(); minStack.push(2); minStack.push(0);
         * minStack.push(3); minStack.push(0); minStack.getMin(); // return -3
         * minStack.pop(); minStack.getMin(); // return -3 minStack.pop();
         * minStack.getMin(); // return -3 minStack.pop(); minStack.top(); // return 0
         * minStack.getMin(); // return -2
         */
    }
}
