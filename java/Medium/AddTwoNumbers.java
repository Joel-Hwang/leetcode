package Medium;

import CS.ListNode;

public class AddTwoNumbers {
    public AddTwoNumbers(){
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(5);

        ListNode c = addTwoNumbers(a, b);
        while(c != null){
            System.out.println(c.val);
            c = c.next;
        }
       
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode crL1 = l1;
        ListNode crL2 = l2;
        ListNode result = new ListNode(), prevResult = new ListNode();
        int idx = 0;
        boolean isOver = false;
        while( crL1 != null || crL2 != null || isOver ){
            ListNode curResult = new ListNode();
            int curSum = sum(isOver,crL1, crL2);
            isOver = false;
            if(curSum >= 10) {
                isOver = true;
                curResult.val = curSum%10;
            }else{
                curResult.val = curSum;
            }
            crL1 = next(crL1);
            crL2 = next(crL2);

            if(idx == 0){
                result = curResult;
            }else{
                prevResult.next = curResult;
            }
            prevResult = curResult;
            idx++;
       }

       return result;
    }

    public int sum(boolean isOver, ListNode a, ListNode b){
        if (a == null && b == null) return 0 + (isOver?1:0);
        else if(a == null && b != null) return b.val + (isOver?1:0);
        else if(b == null && a != null) return a.val + (isOver?1:0);
        else return a.val + b.val + (isOver?1:0);
    }

    public ListNode next(ListNode a){
        return a == null?null:a.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    
}


