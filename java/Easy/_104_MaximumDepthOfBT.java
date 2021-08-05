package Easy;

import java.util.Stack;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _104_MaximumDepthOfBT {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int res = 1;
        root.val = 1;
        Stack<TreeNode> stk = new Stack<>();
        stk.add(root);

        while(!stk.isEmpty()){
            TreeNode cur = stk.pop();
            res = Math.max(res, cur.val);
            if(cur.left != null){
                cur.left.val = cur.val+1;
                stk.add(cur.left);
            }
            if(cur.right != null){
                cur.right.val = cur.val+1;
                stk.add(cur.right);
            }
        }

        return res;
    }

    public int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    @Test
    public void test(){
        System.out.println(maxDepth(null));
        System.out.println(maxDepth(new TreeNode(new Integer[]{})));
        System.out.println(maxDepth(new TreeNode(new Integer[]{0})));
    }
}
