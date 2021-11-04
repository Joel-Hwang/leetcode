package Easy;

import CS.TreeNode;

public class _404_SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null ) return 0;
        return rec(root.left,true) + rec(root.right,false);
    }

    private int rec(TreeNode node, boolean isL){
        if(node == null) return 0;
        if( isL && node.left == null && node.right == null) return node.val;

        return rec(node.left,true) + rec(node.right,false);
    }
}
