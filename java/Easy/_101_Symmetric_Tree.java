package Easy;

import java.util.LinkedList;
import java.util.Queue;

import CS.TreeNode;

public class _101_Symmetric_Tree {
    public _101_Symmetric_Tree(){
        TreeNode root = 
        new TreeNode(1, 
            new TreeNode(2,
                new TreeNode(3),
                new TreeNode(4)), 
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(3)));
        isSymmetric(root);
    }
    

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> l = new LinkedList<>();
        Queue<TreeNode> r = new LinkedList<>();
        l.offer(root);
        r.offer(root);
        while(!l.isEmpty() && !r.isEmpty()){
            
            TreeNode nl = l.poll();
            TreeNode nr = r.poll();
            
            if(nl == null && nr == null) continue;
            if(nl == null && nr != null) return false;
            if(nl != null && nr == null) return false;
            if(nl.val != nr.val) return false;

            l.offer(nl.left);
            l.offer(nl.right);
            r.offer(nr.right);
            r.offer(nr.left);
        }

        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;
        if(l == null || r == null) return false;
        if(l.val != r.val) return false;

        return (l.val == r.val) 
        && isMirror(l.left, r.right) 
        && isMirror(l.right, r.left);
    }
}


