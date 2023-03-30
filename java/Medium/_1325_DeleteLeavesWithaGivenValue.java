package Medium;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _1325_DeleteLeavesWithaGivenValue{
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return root;

        if(removeLeafNodes(root.left, target) == null) root.left = null;
        if(removeLeafNodes(root.right, target) == null) root.right = null;

        if( isLeaf(root) && root.val == target) root = null;
        return root;
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    public TreeNode removeLeafNodes2(TreeNode root, int target) {
        if (root.left != null) root.left = removeLeafNodes(root.left, target);
        if (root.right != null) root.right = removeLeafNodes(root.right, target);
        return root.left == root.right && root.val == target ? null : root;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        removeLeafNodes(root, 2);
    
    
    }

}