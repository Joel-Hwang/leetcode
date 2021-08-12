package Medium;

import java.util.HashMap;
import java.util.Map;

import CS.TreeNode;

public class _106_ConstructBTInorderPostorder {
    Map<Integer, Integer> inMap = new HashMap<>();
    int idx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i<inorder.length; i++) inMap.put(inorder[i], i);
        idx = postorder.length-1;
        return recur(postorder,0,postorder.length-1);
    }

    private TreeNode recur(int[] postorder, int l, int r ){
        if(l>r) return null;
        TreeNode root = new TreeNode(postorder[idx--]);
        root.right = recur(postorder,inMap.get(root.val)+1,r);
        root.left = recur(postorder,l,inMap.get(root.val)-1);
        return root;
    }
}
