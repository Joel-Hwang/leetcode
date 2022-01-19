package Medium;

import CS.ListNode;

public class _142_LinkedListCycleII {
    //head부터 루프 시작점까지 거리 = 루프 시작점부터 slow head가 만나는 거리와 일치
    //head부터 루프 시작점까지를 x1
    //루프 시작점부터 head,slow 만나는 지점까지를 x2
    //둘이 만나는 지점부터 루프 시작점까지를 x3라고 하면
    //fast가 slow를 만날때까지 이동한 거리는 x1+x2+x3+x2
    //slow가 fast를 만날때까지 이동한 거리는 x1+x2
    //fast가 slow보다 2배 이동하니까 2(x1+x2) = x1 + 2(x2) + x3
    //즉 x1 = x3
    //둘이 만났을 때 slow가 head부터 다시 출발하면 다음에 둘이 만나는 지점이 루프 시작점
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
