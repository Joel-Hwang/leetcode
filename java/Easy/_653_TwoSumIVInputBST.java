package Easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _653_TwoSumIVInputBST {
    public boolean findTarget2(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        stk.add(root);
        while(!stk.isEmpty()){
            TreeNode cur = stk.pop();
            if(cur == null) continue;
            if(cur.val<<1 != k && isExist(root, k-cur.val)) return true;
            stk.add(cur.left);
            stk.add(cur.right);
            
        }
        return false;
    }

    //BST Search
    private boolean isExist(TreeNode root, int k){
        if(root == null) return false;
        if(root.val == k) return true;
        if(root.val < k) return isExist(root.right, k);
        if(root.val > k) return isExist(root.left, k);
        return false;
    }


    //Using Set
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(root.val <<1 != k && set.contains(k-root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
        
    }

    @Test
    public void test(){
        System.out.println(findTarget(new TreeNode(new Integer[]{2,1,3}),4));
    }
}
