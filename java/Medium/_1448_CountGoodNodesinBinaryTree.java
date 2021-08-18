package Medium;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _1448_CountGoodNodesinBinaryTree{
    public int goodNodes(TreeNode root) {
        return recur(root,root.val);
    }

    public int recur(TreeNode node, int maxValue){
        if(node == null) return 0;
        maxValue = Math.max(maxValue, node.val);
        return (node.val >= maxValue?1:0) 
        + recur(node.left,maxValue) 
        + recur(node.right,maxValue);
        
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(new Integer[]{3,1,4,3,null,1,5});
        System.out.println(goodNodes(root));
    }
}