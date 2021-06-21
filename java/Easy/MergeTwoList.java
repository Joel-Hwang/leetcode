package Easy;

import CS.ListNode;

public class MergeTwoList {
    public MergeTwoList() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode c1 = l1, c2 = l2, cr = res;

        while (c1 != null || c2 != null) {
            if (c1 == null) {
                cr.next = c2;
                c2 = c2.next;
            } else if (c2 == null) {
                cr.next = c1;
                c1 = c1.next;
            } else {
                if (c1.val < c2.val) {
                    cr.next = c1;
                    c1 = c1.next;
                } else {
                    cr.next = c2;
                    c2 = c2.next;
                }
            }

            cr = cr.next;
        }

        return res.next;
    }
}


/*

public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}

*/