package Medium;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;


public class _138_CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        ArrayList<Node> newList = new ArrayList<>();
        HashMap<Node,Integer> oriMap = new HashMap<>();
        int oriIdx = 0;
        Node res = new Node(0);
        Node curOri = head;
        Node curNew = res;

        while(curOri != null){
            Node next = new Node(curOri.val);
            curNew.next = next;
            newList.add(next);
            oriMap.put(curOri, oriIdx++);
            curOri = curOri.next;
            curNew = curNew.next;
        }

        curOri = head;
        for(int i = 0; i<newList.size(); i++){
            Node cur = newList.get(i);

            if(curOri.random != null)
                cur.random = newList.get(oriMap.get(curOri.random));
            curOri = curOri.next;  
        }

        return res.next;    
    }

    @Test
    public void test(){
        /*Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        n1.random = n2;
        n2.next = null;
        n2.random = n2;*/
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
        
        copyRandomList(n1);
    }


    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
