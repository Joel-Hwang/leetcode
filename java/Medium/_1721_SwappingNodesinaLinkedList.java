package Medium;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

import CS.ListNode;

public class _1721_SwappingNodesinaLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode beforeN1 = null, n1 = null, afterN1 = null;
        ListNode beforeN2 = null, n2 = null, afterN2 = null;
        
        int cnt = getCnt(head);
        if(k > cnt/2) k = cnt-k + 1;
        beforeN1 = getJustPrev(head, k);
        n1 = beforeN1.next;
        afterN1 = beforeN1.next.next;
        
        beforeN2 =getJustPrev(head, cnt-k + 1);
        n2 = beforeN2.next;
        afterN2 = beforeN2.next.next;

        beforeN1.next = n2;
        if(n2 == afterN1 || n1 == afterN2){
            n2.next = n1;
        }else{
            n2.next = afterN1;
            beforeN2.next = n1;
        }
        n1.next = afterN2;


        return k==1?beforeN1.next:head;
    }

    private ListNode getJustPrev(ListNode head, int k){
        ListNode temp = new ListNode();
        temp.next = head;
        int curIdx = 1;
        while(temp.next != null){
            if(curIdx == k){
                ListNode beforeN1 = temp;
                return beforeN1;
            }
            curIdx++;
            temp = temp.next;
        }
        return null;
    }

    private int getCnt(ListNode head){
        ListNode temp = new ListNode();
        temp.next = head;
        int cnt = 0;
        while(temp.next != null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    @Test
    public void test(){
        assertEquals(new ListNode(new int[]{5,2,3,4,1}), swapNodes(new ListNode(new int[]{1,2,3,4,5}), 1));
        assertEquals(new ListNode(new int[]{1,4,3,2,5}), swapNodes(new ListNode(new int[]{1,2,3,4,5}), 2));
        assertEquals(new ListNode(new int[]{90,100}), swapNodes(new ListNode(new int[]{100,90}), 1));
        assertEquals(new ListNode(new int[]{90,100}), swapNodes(new ListNode(new int[]{100,90}), 2));
    }
}
