package Hard;

public class _25_ReverseNode {
    
    public _25_ReverseNode(){
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(6);
      reverseKGroup(head,4);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode c = res;
        ListNode ps = c.next;  //preserve start
        ListNode pe = c.next;  //preserve end
        ListNode f = pe.next; // it will be first node
        ListNode s = f.next; //suffix node
        
        c.next = f;
        pe.next=s;
        f.next=ps;

        for(int i=3;i<=k;i++){
          ps=c.next;
          pe=pe;
          f=s;
          s=s.next;
          c.next = f;
          pe.next=s;
          f.next=ps;
        }

        return res.next;
    }

    
    /*
     0-1   -  2 - 3-4-5-6
      as,ae   b   c
    o-b-as,ae-c
      as=o.next
      ae=as
      b=ae.next
      c=b.next
      o.next=b
      ae.next=c
      b.next=as


     as=o.next
     ae=ae
     b=c
     c=c.next 
     o.next=b
     ae.next=c
     b.next=as 
    


    k=4
    c-1-2-3-4-5
    c-2-1-3-4-5
    c-3-2-1-4-5
    c-4-3-2-1-5
    

    */

    
}
