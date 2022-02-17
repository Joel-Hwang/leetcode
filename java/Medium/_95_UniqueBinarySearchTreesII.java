package Medium;

import java.util.*;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _95_UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int low, int high){
        List<TreeNode> res = new ArrayList<>();
        if(high<low){
            res.add(null);
            return res;
        } 

        for(int root = low; root<=high; root++){
            List<TreeNode> left = helper(low, root-1);
            List<TreeNode> right = helper(root+1, high);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    res.add(new TreeNode(root, l, r));
                }
            }
        }

        return res;
    }

   

    @Test
    public void test(){
        List<TreeNode> test = generateTrees(3);
    }
}
