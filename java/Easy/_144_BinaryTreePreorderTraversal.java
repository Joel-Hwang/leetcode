package Easy;

import java.util.*;

import CS.TreeNode;

public class _144_BinaryTreePreorderTraversal{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }
    
    private void preorder(TreeNode node, List<Integer> res){
        if(node == null) return;
        res.add(node.val);
        preorder(node.left,res);
        preorder(node.right,res);
    }
}