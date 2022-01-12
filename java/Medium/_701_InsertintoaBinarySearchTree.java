package Medium;

import CS.TreeNode;

public class _701_InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        rec(root, val);
        return root;
    }

    private TreeNode rec(TreeNode node, int val) {
        if (node == null)
            return new TreeNode(val);

        if (node.val < val) {
            TreeNode temp = rec(node.right, val);
            if (temp != null)
                node.right = temp;
        } else {
            TreeNode temp = rec(node.left, val);
            if (temp != null)
                node.left = temp;
        }
        return null;
    }
}
