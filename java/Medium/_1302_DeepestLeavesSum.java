package Medium;

import java.util.ArrayList;

import CS.TreeNode;

public class _1302_DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        //depth, value
        ArrayList<int[]> lefs = new ArrayList<int[]>();
        dfs(root,1,lefs);

        int res = lefs.get(0)[1];
        int maxDepth = lefs.get(0)[0];
        for(int i = 1; i<lefs.size(); i++) {
            if(lefs.get(i)[0] < maxDepth) break;
            res += lefs.get(i)[1];
        }
        return res;
    }

    public void dfs(TreeNode root,int depth, ArrayList<int[]> lefs) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(lefs.size()>0 && depth >= lefs.get(0)[0])
                lefs.add(0,new int[]{depth,root.val});
            else lefs.add(new int[]{depth,root.val});
            return;
        }
        dfs(root.left,depth+1,lefs);
        dfs(root.right,depth+1,lefs);
    }
}
