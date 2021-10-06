package Medium;

import org.testng.annotations.Test;

import CS.ListNode;

public class _86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode temp = new ListNode(0);
        ListNode l = temp;
        ListNode c = temp;
        c.next = head;
        while (c.next != null) {
            if (c.next.val < x) {
                if (l.next == c.next) {
                    l = c.next;
                    c = c.next;
                    continue;
                }

                ListNode tmp1S = l.next;
                ListNode tmp1E = c;
                ListNode tmp2 = c.next.next;
                l.next = c.next;
                c.next.next = tmp1S;
                tmp1E.next = tmp2;
                c = tmp1E;
                l = l.next;
            } else {
                c = c.next;
            }
        }
        return temp.next;
    }

    public ListNode partition2(ListNode head, int x) {

        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(new int[] { 2, 1 });
        // ListNode head = new ListNode(new int[]{1,4,3,2,5,2});
        // ListNode head = new ListNode(new int[]{1,4,3,0,2,5,2});
        ListNode test = partition(head, 2);
        test.print();
    }
}
