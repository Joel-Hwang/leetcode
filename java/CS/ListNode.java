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
}