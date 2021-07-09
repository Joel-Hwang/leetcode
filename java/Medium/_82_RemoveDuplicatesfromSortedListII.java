package Medium;

import org.testng.annotations.Test;

import CS.ListNode;

public class _82_RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode c = temp;
        ListNode origin = null;
        boolean inSame = false;
        while(c.next != null && c.next.next != null){
            if(c.next.val == c.next.next.val){
                if(inSame){
                    c = c.next;
                }else{
                    origin = c;
                    inSame = true;
                    c = c.next;
                }
                
            }else{
                if(inSame){
                    origin.next = c.next.next;
                    c = origin;
                    inSame = false;
                }else{
                    c = c.next;
                }
            }
        }

        if(inSame){
            origin.next = null;
            c = origin;
        }
        return temp.next;
    }

    @Test
    public void test(){
        ListNode a = new ListNode(new int[]{0,1,1});
        ListNode r = deleteDuplicates(a);
    }
}
