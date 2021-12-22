package Medium;

import java.util.ArrayList;
import java.util.Stack;

import org.testng.annotations.Test;

import CS.ListNode;

public class _143_ReorderList {
    public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur);
            cur = cur.next;
            list.get(list.size()-1).next = null;
        }
        

        ListNode temp = new ListNode();
        cur = temp;
        for(int i = 0; i<list.size()/2; i++){
            cur.next = list.get(i);
            cur = cur.next;
            cur.next = list.get(list.size()-1-i);
            cur = cur.next;

        }

        if(list.size()%2 == 1)
            cur.next = list.get(list.size()/2);

        head = temp.next;
    }

    public void reorderList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        int size = (stack.size()-1)/2;
        curr = head;
        while(size-- > 0){
            ListNode top = stack.pop();
            ListNode temp = curr.next;
            curr.next = top;
            top.next = temp;
            curr = temp;
        }
        stack.pop().next = null;
    }


    @Test
    public void test(){
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        reorderList(a);

        ListNode res = a;

    }
}
