package Medium;

import java.util.Stack;

import CS.TreeNode;

public class _1379_FindaCorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Stack<TreeNode> stkOri = new Stack<>();
        Stack<TreeNode> stkClon = new Stack<>();
        stkOri.add(original);
        stkClon.add(cloned);
        while(!stkOri.isEmpty()){
            TreeNode curOri = stkOri.pop();
            TreeNode curClon = stkClon.pop();
            if(curOri == target) return curClon;

            if(curOri.left != null){
                stkOri.add(curOri.left);
                stkClon.add(curClon.left);
            }

            if(curOri.right != null){
                stkOri.add(curOri.right);
                stkClon.add(curClon.right);
            }
        }
        
        return null;
    }
}
