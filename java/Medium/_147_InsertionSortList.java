package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.testng.annotations.Test;

import CS.ListNode;

public class _147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur);
            cur = cur.next;
        }

        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            };
        });

        ListNode res = new ListNode();
        cur = res;
        int i = 0;
        for(ListNode node : list){
            if(i == list.size()-1) node.next = null;
            cur.next = node;
            cur = cur.next;
            i++;
        }
        return res.next;
    }

    @Test
    public void test(){
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        insertionSortList(node);
    }
}
