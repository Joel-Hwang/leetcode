package Medium;

import java.util.LinkedList;
import java.util.Queue;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _1161_MaximumLevelSumofBinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int res = 0;
        int maxSum = -100000;
        while (!q.isEmpty()) {
            level++;
            int s = q.size();
            int curSum = 0;
            for (int i = 0; i < s; i++) {
                TreeNode c = q.poll();
                curSum += c.val;
                if (c.left != null)
                    q.add(c.left);
                if (c.right != null)
                    q.add(c.right);
            }
            if(maxSum < curSum){
                maxSum = curSum;
                res = level;
            }
            
        }
        return res;
    }

    @Test
    public void test(){
       TreeNode a = new TreeNode(new Integer[]{-100,-200,-300,-20,-5,-10,null}); 
       System.out.println(maxLevelSum(a));
    }
}
