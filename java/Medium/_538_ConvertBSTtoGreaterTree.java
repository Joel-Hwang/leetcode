package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _538_ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preOrder(root,list);

        for(int i = list.size()-2; i>=0; i--){
            list.get(i).val += list.get(i+1).val;
        }
        return root;
    }

    private void preOrder(TreeNode node, List<TreeNode> list){
        if(node == null) return;
        preOrder(node.left,list);
        list.add(node);
        preOrder(node.right,list);
    }

    @Test
    public void test(){
        TreeNode node = null;
        TreeNode expected = null;
        node = new TreeNode(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        expected = new TreeNode(new Integer[]{30,36,21,36,35,26,15,null,null,null,33,null,null,null,8});
        assertEquals(expected.toString(), convertBST(node).toString());
    
    }
}
