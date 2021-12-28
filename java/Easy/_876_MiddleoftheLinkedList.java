package Easy;

import org.testng.annotations.Test;

import CS.ListNode;

public class _876_MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode cur1 = head;
        ListNode cur2 = head;

        while(cur1.next != null){
            if(cur2 == null || cur2.next == null) return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        return cur1;
    }

    @Test
    public void test(){
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        middleNode(test);
    }
}
