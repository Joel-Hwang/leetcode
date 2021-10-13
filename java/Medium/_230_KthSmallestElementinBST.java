package Medium;

import java.util.ArrayList;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _230_KthSmallestElementinBST {
    
    ArrayList<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        rec(root,k);
        return list.get(k-1);
    }

    public void rec(TreeNode node, int k){
        if(list.size() == k) return;
        if(node == null) return;
        rec(node.left,k);
        list.add(node.val);
        rec(node.right,k);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthSmallest(root, 1));
    }
    
}
