package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _113_PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root,targetSum,ret,new ArrayList<Integer>());
        return ret;
    }

    public void dfs(TreeNode node, int targetSum, List<List<Integer>> ret, List<Integer> p){
        if(node == null) return; 
        if(node.left == null && node.right == null ){
            if(node.val == targetSum){
                p.add(node.val);
                ret.add(new ArrayList<Integer>(p)); 
                p.remove(p.size()-1);
            }
            return;
        }
        p.add(node.val);
        dfs(node.left, targetSum - node.val, ret, p);
        dfs(node.right, targetSum - node.val, ret, p);
        p.remove(p.size()-1);
    }

    @Test
    public void test(){
        List<List<Integer>> ret  =  pathSum(new TreeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,null,5,1}), 22);
        for(List<Integer> r : ret)
            System.out.println(Arrays.toString(r.toArray()));
    
    }
}
