package Easy;

import java.util.HashSet;
import java.util.Set;

import CS.ListNode;

public class _141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet();
        while(head != null){
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        } 
        return false;
    }
}
