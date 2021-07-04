package Easy;

import java.util.LinkedList;
import java.util.Queue;

import CS.TreeNode;

public class _617_MergeTwoBinaryTrees {
    public _617_MergeTwoBinaryTrees() {
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(3);
        r1.right = new TreeNode(2);
        r1.left.left = new TreeNode(5);

        TreeNode r2 = new TreeNode(2);
        r2.left = new TreeNode(1);
        r2.right = new TreeNode(3);
        r2.left.right = new TreeNode(4);
        r2.right.right = new TreeNode(7);
        //TreeNode rs = mergeTrees2(r1, r2);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        Queue<TreeNode[]> q1 = new LinkedList<>();
        q1.add(new TreeNode[] { root1, root2 });
        while (!q1.isEmpty()) {
            TreeNode[] cur = q1.poll();
            if (cur[0] == null) continue;
            if (cur[1] == null) cur[1] = new TreeNode(0);
            cur[0].val += cur[1].val;

            if (cur[0].left == null) {
                cur[0].left = cur[1].left;
                cur[1].left = null;
            }
            q1.add(new TreeNode[]{cur[0].left, cur[1].left});
            if(cur[0].right == null){
                cur[0].right = cur[1].right;
                cur[1].right = null;
            }
            q1.add(new TreeNode[]{ cur[0].right, cur[1].right});
        }
        return root1;
    }

}
