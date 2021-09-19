package Easy;

import CS.TreeNode;

public class _938_RangeSumBST {
    int res = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        if (root.val < low)
            return rangeSumBST(root.right, low, high);
        if (root.val > high)
            return rangeSumBST(root.left, low, high);

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

    }
}
