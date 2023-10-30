package Easy;

import org.testng.annotations.Test;

import CS.ListNode;

public class _21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode tempCursor = temp;
        ListNode list1Cursor = list1;
        ListNode list2Cursor = list2;
        while (list1Cursor != null || list2Cursor != null) {
            tempCursor.next = getSmallerNode(list1Cursor, list2Cursor);
            tempCursor = tempCursor.next;

            if(tempCursor == list1Cursor) list1Cursor = list1Cursor.next;
            else if(tempCursor == list2Cursor) list2Cursor = list2Cursor.next;
            else;
        }
        return temp.next;
    }

    private ListNode getSmallerNode(ListNode node1, ListNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        if(node1.val < node2.val) return node1;
        else return node2;
    }

    @Test
    public void test(){
        ListNode temp = new ListNode(1);
        temp.next = new ListNode(2);
        temp.next.next = new ListNode(4);
        ListNode temp2 = new ListNode(1);
        temp2.next = new ListNode(3);
        temp2.next.next = new ListNode(4);

        System.out.println(mergeTwoLists(temp, temp2));
    }
}
