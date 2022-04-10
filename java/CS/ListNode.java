package CS;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] vals) {
        this.val = vals[0];
        ListNode c = this;
        for(int i = 1; i<vals.length; i++){
            c.next = new ListNode(vals[i]);
            c = c.next;
        }
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print(){
        ListNode c = this;
        while(c != null){
            System.out.print(c.val+" -> ");
            c = c.next;
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        ListNode tem1 = new ListNode();
        tem1.next = this;
        ListNode tem2 = new ListNode();
        tem2.next = (ListNode)obj;
        while(tem1.next!= null && tem2.next!= null){
            if(tem1.next.val != tem2.next.val) return false;
            tem1 = tem1.next;
            tem2 = tem2.next;
        }
        //if(tem1.next == null  && tem2.next == null)
        //    return true;
        return tem1.next == null && tem2.next == null;
    }
}