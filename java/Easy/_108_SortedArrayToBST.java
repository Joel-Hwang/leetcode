package Easy;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _108_SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums,0,nums.length-1);
    }

    private TreeNode recur(int[] nums, int l, int r){
        if(l>r) return null;
        int idx = (l+r)/2;
        TreeNode root = new TreeNode(nums[idx]);
        root.left = recur(nums,l,idx-1);
        root.right = recur(nums,idx+1,r);
        return root;
    }

    @Test
    public void test(){
        System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
