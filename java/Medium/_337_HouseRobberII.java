package Medium;

import CS.TreeNode;

public class _337_HouseRobberII {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);        
    }

    //[0] : with me
    //[1] : without me
    public int[] dfs(TreeNode node){
        if(node == null) return new int[2];
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] res = new int[2];
        res[0] = node.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
