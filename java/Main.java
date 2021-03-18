import Medium.*;
import CS.LinkedListNode;
import CS.Node;
import Easy.*;
import Hard.*;

public class Main {
    public static void main(String[] args) {
        LinkedListNode aa = new LinkedListNode();

        LinkedListNode.Node l3 = new LinkedListNode.Node(5);
        l3.next = new LinkedListNode.Node(6);
        l3.next.next = new LinkedListNode.Node(7);
        l3.next.next.next = new LinkedListNode.Node(8);

        LinkedListNode.Node l1 = new LinkedListNode.Node(1);
        l1.next = new LinkedListNode.Node(2);
        l1.next.next = new LinkedListNode.Node(3);
        l1.next.next.next = l3;
        LinkedListNode.Node l2 = new LinkedListNode.Node(1);
        l2.next = new LinkedListNode.Node(2);
        l2.next.next = l3;

        System.out.println(aa.findCross(l1, l2).data);
    }

}