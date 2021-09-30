package Medium;

import java.util.ArrayList;
import java.util.List;

import CS.TreeNode;

public class _173_BinarySearchTreeIterator {
    class BSTIterator {
        List<Integer> list = new ArrayList<>();
        int i = -1;
        public BSTIterator(TreeNode root) {
            preorder(root);
        }

        public void preorder(TreeNode node){
            if(node == null) return;
            preorder(node.left);
            list.add(node.val);
            preorder(node.right);
        }
        
        public int next() {
            return list.get(++i);
        }
        
        public boolean hasNext() {
            return i+1 < list.size();
        }
    }
    
}
