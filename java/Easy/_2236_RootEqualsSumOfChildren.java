package Easy;

import CS.TreeNode;

public class _2236_RootEqualsSumOfChildren {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }    
}
