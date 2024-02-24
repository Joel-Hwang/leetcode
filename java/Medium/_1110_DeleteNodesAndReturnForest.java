package Medium;

import java.util.*;

import CS.TreeNode;
public class _1110_DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> willBeDeleted = new HashSet<>(); 
        for(int num : to_delete) willBeDeleted.add(num);

        List<TreeNode> res = new ArrayList<>();
        TreeNode temp = new TreeNode();
        temp.left = root;
        
        dfs(temp,root,willBeDeleted,res);

        if(willBeDeleted.contains(root.val) )
            return res;
        
        res.add(root);
        return res;

    }

    private void dfs(TreeNode parent, TreeNode node, Set<Integer> willBeDeleted, List<TreeNode> res){
        if(node== null) return;

        dfs(node, node.left, willBeDeleted, res);
        dfs(node, node.right, willBeDeleted, res);

        if(willBeDeleted.contains(node.val) == false) 
            return;
        
        if(parent.left == node) parent.left = null;
        if(parent.right == node) parent.right = null;
        if(node.left != null) res.add(node.left);
        if(node.right != null) res.add(node.right);
        
        
    }
}
