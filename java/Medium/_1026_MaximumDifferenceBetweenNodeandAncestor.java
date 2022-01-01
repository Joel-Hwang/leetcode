package Medium;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _1026_MaximumDifferenceBetweenNodeandAncestor {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root,root.val,root.val);
        return res;
    }

    private void dfs(TreeNode node, int max, int min){
        if(node == null) return;
        int curAns = Math.max(Math.abs(node.val-max),Math.abs(node.val-min));
        res = Math.max(res, curAns);
        dfs(node.left, Math.max(node.val,max), Math.min(node.val,min));
        dfs(node.right, Math.max(node.val,max), Math.min(node.val,min));
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println(maxAncestorDiff(root));
    }
}
