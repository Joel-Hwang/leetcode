package Medium;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import CS.ListNode;
import CS.TreeNode;

public class _109_ConvertSortedListBST{
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            nodes.add(cur.val);
            cur = cur.next;
        }

        return recur(nodes,0,nodes.size()-1);
    }

    private TreeNode recur(List<Integer> nums, int l, int r){
        if(l>r) return null;
        int idx = (l+r)/2;
        TreeNode root = new TreeNode(nums.get(idx));
        root.left = recur(nums,l,idx-1);
        root.right = recur(nums,idx+1,r);
        return root;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
       if(head == tail) return null;
       ListNode slow = head;
       ListNode fast = head;
       while(fast != tail && fast.next != tail){
           slow = slow.next;
           fast = fast.next.next;
       }
       TreeNode root = new TreeNode(slow.val);
       root.left = toBST(head,slow);
       root.right = toBST(slow.next, tail);
       return root;
    }


    @Test
    public void test(){
        //TreeNode test2 = sortedListToBST2(new ListNode(new int[]{0,1,2,3,4,5,6}));
        //System.out.println(test2);
        TreeNode test = sortedListToBST2(new ListNode(new int[]{0,1}));
        TreeNode test3 = sortedListToBST2(new ListNode(new int[]{-10,-3,0,5,9}));
    }
}