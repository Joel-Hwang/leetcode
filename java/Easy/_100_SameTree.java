package Easy;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _100_SameTree{
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null && q!= null) return false;
        if(p != null && q== null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    @Test
    public void test(){
        System.out.println(
            isSameTree(
                new TreeNode(new Integer[]{1,2,3}), 
                new TreeNode(new Integer[]{1,2,3})
                )
        );
    }
}