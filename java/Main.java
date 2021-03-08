import Medium.*;
import CS.LinkedListNode;
import CS.Node;
import Easy.*;
import Hard.*;

public class Main {
    public static void main(String[] args) {
        LinkedListNode ll = new LinkedListNode();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.retrieve();
        ll.deleteNode(ll.header.next.next);
        ll.retrieve();
        //System.out.println(ll.kthLast(ll.header,2).getData());
        //System.out.println(ll.kthLast2(ll.header,2).getData());
        //System.out.println(ll.kthLast3(ll.header,4).getData());
    }
}