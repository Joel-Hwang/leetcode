namespace Csharp
{
    public class AddTwoNumbers
    {
        public AddTwoNumbers(){
            ListNode a = new ListNode(1);
            ListNode b = new ListNode(9);
            b.next = new ListNode(9);
            addTwoNumbers(a,b);
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2)
        {
            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;
            ListNode p = l1, q = l2;
            int carry = 0;
            while(p != null || q!= null ){
                int x = (p!=null)?p.val:0;
                int y = (q!=null)?q.val:0;
                int sum = x+y+carry; 
                carry = sum/10;
                curr.next = new ListNode(sum%10);
                curr = curr.next;

                if(p!= null) p = p.next;
                if(q!= null) q = q.next;
            }
            if(carry>0) curr.next = new ListNode(carry);
            return dummyHead.next;
        }
    }


    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int val = 0, ListNode next = null)
        {
            this.val = val;
            this.next = next;
        }
    }
}
