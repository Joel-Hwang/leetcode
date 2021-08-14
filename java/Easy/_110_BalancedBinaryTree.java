package Easy;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return recur(root).sub;
    }

    public Res recur(TreeNode root){
        if(root == null) return new Res(true,0);

        Res resL = recur(root.left);
        if(resL.sub == false) return resL;
        Res resR = recur(root.right);
        if(resR.sub == false) return resR;
        if(Math.abs(resL.h-resR.h)<=1){
            return new Res(true,Math.max(resL.h, resR.h)+1);
        }
        return new Res(false,0);
    }

    
    class Res{
        public boolean sub;
        public int h;
        public Res(boolean sub, int h){
            this.sub = sub;
            this.h = h;
        }
    }


    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode rr = new TreeNode(3);
        root.right = r;
        root.right.right = rr;
        System.out.println(isBalanced(root));
    }
}

