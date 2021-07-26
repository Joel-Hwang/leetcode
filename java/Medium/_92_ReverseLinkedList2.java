package Medium;

import org.testng.annotations.Test;

import CS.ListNode;

public class _92_ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt = 0;
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode start = temp, end = temp;
        ListNode before;

        while(end.next != null){
            cnt++;

            if(cnt == right){
                before = start; //1
                start = start.next; //2
                end = end.next;  //4
                ListNode prevNs = start;
                for(int i = 0; i<right-left; i++){
                    ListNode ns = start.next;
                    start.next = ns.next;
                    ns.next = prevNs;
                    prevNs = ns;
                }
                before.next = prevNs;
                break;
            }

            end = end.next;
            if(cnt>right-left)
                start = start.next;
        }
        return temp.next;
    }



    @Test
    public void test(){
        reverseBetween(new ListNode(new int[]{5}),1,1).print();
        reverseBetween(new ListNode(new int[]{1,2,3,4,5}),2,4).print();
        
    }
}
