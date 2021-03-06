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
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.retrieve();
        System.out.println(ll.kthLast(ll.header,6).getData());
    }
}