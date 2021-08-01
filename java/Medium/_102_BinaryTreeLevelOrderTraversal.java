package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,0,res);
        return res;
    }

    public void dfs(TreeNode node, int p, List<List<Integer>> res ){
        if(node == null) return;
        if(res.size() < p+1) res.add(new ArrayList<>());
        res.get(p).add(node.val);
        dfs(node.left,p+1,res);
        dfs(node.right,p+1,res);
    }
    @Test
    public void test(){
        List<List<Integer>> res = levelOrder(new TreeNode(new Integer[]{3,9,20,null,null,15,7}));
        for(int i = 0; i<res.size(); i++)
            System.out.println(Arrays.toString(res.get(i).toArray()));
    }
   
}
