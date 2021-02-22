package Hard;

public class _23_MergeKSortedList {
    public _23_MergeKSortedList(){
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);

        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNode c = new ListNode(2);
        c.next = new ListNode(6);

        ListNode[] sample = new ListNode[]{a,b,c};
        mergeKLists(sample);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode[] cur = new ListNode[lists.length];
        ListNode res = new ListNode(0);
        ListNode curRes = res;
        for(int i = 0; i<lists.length; i++){
            cur[i] = lists[i];
        }
        ListNode curMax;
        while( (curMax= getMinCurIdx(cur)) != null ){
            curRes.next = curMax;
            curRes = curRes.next;
        }


        return res.next;
    }

    public ListNode getMinCurIdx(ListNode[] cur){
       if(cur.length == 0) return null;
        ListNode res = null;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i = 0; i<cur.length; i++){
            if(cur[i] == null) continue;
            if(min > cur[i].val){
                min = cur[i].val;
                res = cur[i];
                minIdx = i;
            }
        }
        if(minIdx<0) return null;
        cur[minIdx] = cur[minIdx].next;
        return res;
    }

}




class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 

 /*
 public static ListNode mergeKLists(ListNode[] lists){
    return partion(lists,0,lists.length-1);
}

public static ListNode partion(ListNode[] lists,int s,int e){
    if(s==e)  return lists[s];
    if(s<e){
        int q=(s+e)/2;
        ListNode l1=partion(lists,s,q);
        ListNode l2=partion(lists,q+1,e);
        return merge(l1,l2);
    }else
        return null;
}

//This function is from Merge Two Sorted Lists.
public static ListNode merge(ListNode l1,ListNode l2){
    if(l1==null) return l2;
    if(l2==null) return l1;
    if(l1.val<l2.val){
        l1.next=merge(l1.next,l2);
        return l1;
    }else{
        l2.next=merge(l1,l2.next);
        return l2;
    }
}
 
 */