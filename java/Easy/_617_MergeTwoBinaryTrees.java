package Easy;

public class _617_MergeTwoBinaryTrees {
    public _617_MergeTwoBinaryTrees(){

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
         Queue<TreeNode> r1 = new LinkedList<TreeNode>();
         Queue<TreeNode> r2 = new LinkedList<TreeNode>();
         
        return null;
    }
    
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }