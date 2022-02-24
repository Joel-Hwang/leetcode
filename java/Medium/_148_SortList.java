package Medium;

import java.util.ArrayList;
import java.util.Collections;

import CS.ListNode;

public class _148_SortList {
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        ArrayList<ListNode> ar = new ArrayList<>();
        ListNode cursor = head;

        while(cursor != null){
            ar.add(cursor);
            cursor = cursor.next;
        }

        Collections.sort(ar, (ListNode o1, ListNode o2) -> {
            return o1.val - o2.val;
        });

        for(int i = 0; i<ar.size()-1; i++){
            ar.get(i).next = ar.get(i+1);
        }
        ar.get(ar.size()-1).next = null;
        return ar.get(0);
    }
}
