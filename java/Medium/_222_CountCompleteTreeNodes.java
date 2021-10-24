package Medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import CS.TreeNode;

public class _222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            res++;
            TreeNode cur = q.poll();
            if(cur.left != null)
            q.add(cur.left);
            if(cur.right != null)
            q.add(cur.right);
        }
        return res;
    }
}
