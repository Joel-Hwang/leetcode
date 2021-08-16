package Easy;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _112_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(root.val == targetSum) return true;
            else return false;
        }

        boolean left = root.left == null?false : hasPathSum(root.left, targetSum-root.val) ;
        boolean right = root.right == null?false : hasPathSum(root.right, targetSum-root.val);

        return left || right;
    }
   
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) return false;
    
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
    
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    @Test
    public void test(){
        hasPathSum(new TreeNode(new Integer[]{1,2,null}), 1);
    }

}
