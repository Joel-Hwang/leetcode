package Medium;


import org.testng.annotations.Test;

import CS.TreeNode;

public class _1339_MaximumProductOfSplittedBinaryTree {
    long sum = 0, total;
    public int maxProduct(TreeNode root) {
        getTotal(root);
        getMax(root);
        return (int)(total % (int)(1e9 + 7));
    }

    private void getTotal(TreeNode root){
        if(root == null) return;
        sum += root.val;
        getTotal(root.left);
        getTotal(root.right);
    }

    private long getMax(TreeNode root){
        if(root == null) return 0;
        long l = getMax(root.left);
        long r = getMax(root.right);
        long subTotal = root.val + l + r;
        total = Math.max(total, (sum - subTotal) * subTotal);
        return subTotal;
    }

    /*
    long res = 0, total = 0, sub;
    public int maxProduct(TreeNode root) {
        total = s(root); s(root);
        return (int)(res % (int)(1e9 + 7));
    }

    private long s(TreeNode root) {
        if (root == null) return 0;
        sub = root.val + s(root.left) + s(root.right);
        res = Math.max(res, sub * (total - sub));
        return sub;
    }
    */


    @Test
    public void test(){
        TreeNode root = new TreeNode(new Integer[]{1,1});
        int test = maxProduct(root);
        System.out.println(test);
    }
}
