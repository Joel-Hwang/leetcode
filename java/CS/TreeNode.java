package CS;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode(Integer[] ar) {
        Queue<TreeNode> q = new LinkedList<>();
        this.val = ar[0];
        q.add(this);
        for(int i = 1; i<ar.length; i+=2){
            TreeNode cur = q.poll();
            if(cur == null) continue;
            cur.left = (ar[i] ==null?null:new TreeNode(ar[i]));
            cur.right = (ar[i+1] ==null?null:new TreeNode(ar[i+1]));
            q.add(cur.left);
            q.add(cur.right);
        }
    }
}
