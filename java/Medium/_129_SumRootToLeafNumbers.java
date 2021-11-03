package Medium;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _129_SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int childSum = cur(root.left,root.val) + cur(root.right,root.val);
        if(childSum == 0)
            return root.val;
        else
            return childSum;
    }

    private int cur(TreeNode node, int p){
        if(node==null) return 0;
        int c = p*10 + node.val;
        
        int childSum = cur(node.left,c) + cur(node.right,c);
        if(childSum == 0)
            return c;
        else
            return childSum;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(new Integer[]{1,2,3});
        System.out.println(sumNumbers(root));
    }
}
