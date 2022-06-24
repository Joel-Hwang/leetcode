package Easy;

import java.util.ArrayList;
import java.util.List;

import CS.ListNode;

public class _206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        List<ListNode> nodes = new ArrayList<>();
        ListNode cursor = head;
        while(cursor != null){
            nodes.add(cursor);
            cursor = cursor.next;
        }

        ListNode res = new ListNode();
        res.next = nodes.get(nodes.size()-1);
        for(int i = nodes.size()-2; i>=0; i--){
            nodes.get(i+1).next = nodes.get(i);
        }
        nodes.get(0).next = null;
        return res.next;

    }
}
