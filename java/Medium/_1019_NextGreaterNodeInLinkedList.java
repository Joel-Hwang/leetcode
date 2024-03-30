package Medium;

import CS.ListNode;
import java.util.*;
public class _1019_NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        List<ListNode> nodeList= new ArrayList<>();
        while(head != null){
            nodeList.add(head);
            head = head.next;
        }

        int[] res = new int[nodeList.size()];
        Map<ListNode, ListNode> map = new HashMap<>();
        map.put(nodeList.getLast(),new ListNode(0));
        for(int i = nodeList.size()-2; i>=0; i--){
            if(nodeList.get(i).val < nodeList.get(i+1).val)
                map.put(nodeList.get(i), nodeList.get(i+1));
            else{
                ListNode cur = map.get(nodeList.get(i+1));
                while(map.get(nodeList.get(i)) == null){
                    if(nodeList.get(i).val < cur.val || cur.val == 0)
                        map.put(nodeList.get(i), cur);
                    else
                        cur = map.get(cur);
                }
            }
        }

        for(int i = 0; i<res.length; i++)
            res[i] = map.get(nodeList.get(i)).val;
        
        return res;
    }
}
