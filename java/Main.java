import Medium.*;
import CS.LinkedListNode;
import CS.Node;
import Easy.*;
import Hard.*;

public class Main {
    public static void main(String[] args) {
        LinkedListNode lln = new LinkedListNode();
        
        LinkedListNode.Node l1 = new LinkedListNode.Node(9);
        l1.next = new LinkedListNode.Node(1);
        l1.next.next = new LinkedListNode.Node(4);

        
        LinkedListNode.Node l2 = new LinkedListNode.Node(6);
        l2.next = new LinkedListNode.Node(4);
        l2.next.next = new LinkedListNode.Node(3);


        lln.addReverse(l1, l2);
    }
    
}