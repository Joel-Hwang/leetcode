package Medium;

import java.util.ArrayList;
import java.util.List;

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
}