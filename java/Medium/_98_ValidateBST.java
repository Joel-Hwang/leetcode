package Medium;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _98_ValidateBST {
    public boolean isValidBST2(TreeNode root) {
        return isValid(root, new ArrayList<>(), new ArrayList<>());
    }

    private boolean isValid(TreeNode root, List<Integer> pL, List<Integer> pR){
        if(root == null) return true;
        boolean res = true;
        if(root.left != null && root.left.val >= root.val) res = false;
        if(root.right != null && root.right.val <= root.val) res = false;
        if(!res) return false;

        for(int l : pL){
            if(root.val >= l) return false;
        }
        for(int r : pR){
            if(root.val <= r) return false;
        }

        pL.add(root.val);
        boolean isValidLeft = isValid(root.left, pL, pR);
        
        pL.remove(pL.size()-1);
        pR.add(root.val);
        boolean isValidRight = isValid(root.right, pL, pR);
        return  isValidLeft && isValidRight;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    @Test
    public void test(){
        System.out.println(isValidBST(new TreeNode(new Integer[]{4,3,null,2,null,null,null,1,null,null,null,null,null,null,null,null,5})));
        System.out.println(isValidBST(new TreeNode(new Integer[]{3,1,5,0,2,4,6,null,null,null,3})));
        System.out.println(isValidBST(new TreeNode(new Integer[]{2,1,3})));
        System.out.println(isValidBST(new TreeNode(new Integer[]{5,1,4,null,null,3,6})));
        System.out.println(isValidBST(new TreeNode(new Integer[]{5,4,6,null,null,3,7})));
    }
}
