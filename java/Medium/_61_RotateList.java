package Medium;

import org.testng.annotations.Test;

import CS.ListNode;

public class _61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        
        ListNode fir = head;
        ListNode sec = head;
        int length = 0;
        while(fir != null){length++; fir = fir.next;}

        k = k%length;
        fir = head;
        if(k==0 || head == null || head.next == null) return head;
        
        while(fir.next != null){
            fir = fir.next;
            sec = sec.next;
            k--;
            if(k == 0){
                sec = head;
            }
        }

        ListNode res = sec.next;
        sec.next = null;
        fir.next = head;

        return res;
    }

    @Test
    public void test(){
        ListNode a = rotateRight(new ListNode(new int[]{1,2}), 2);
        while(a != null){
            System.out.print(a.val + "->");
            a = a.next;
        }
        System.out.println();

        a = rotateRight(new ListNode(new int[]{1,2,3,4,5}), 2);
        while(a != null){
            System.out.print(a.val + "->");
            a = a.next;
        }
        System.out.println();

        a = rotateRight(new ListNode(new int[]{0,1,2}), 4);
        while(a != null){
            System.out.print(a.val + "->");
            a = a.next;
        }
        System.out.println();
    }
}
