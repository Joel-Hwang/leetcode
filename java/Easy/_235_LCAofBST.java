package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _235_LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //left subtree
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val>root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else return root;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(new Integer[]{6,2,8,1,4,7,9,null,null,3,5});
        TreeNode p = root.right.left;
        TreeNode q = root.right.right;

        assertEquals(lowestCommonAncestor(root, p, q).val,8);
    }

    
}
