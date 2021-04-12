package Easy;

import java.util.LinkedList;
import java.util.Queue;

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
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> l = new LinkedList<>();
        LinkedList<Integer> r = new LinkedList<>();
        q.offer(root);
        int cnt = 0;
        while(!q.isEmpty()){
            cnt++;
            TreeNode node = q.poll();
            if(node == null) continue;
            System.out.println(node.val);
            q.offer(node.left);
            q.offer(node.right);

        }

        return true;
    }
}




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}