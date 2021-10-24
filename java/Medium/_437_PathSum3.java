package Medium;

import CS.TreeNode;

public class _437_PathSum3 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return rec(root,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }

    private int rec(TreeNode node, int targetSum){
        if(node == null) return 0;
        return (node.val == targetSum?1:0) + rec(node.left, targetSum-node.val)+rec(node.right,targetSum-node.val);
    }

}
