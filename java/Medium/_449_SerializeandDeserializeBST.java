package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _449_SerializeandDeserializeBST {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String in = inOrder(root);
            String post = postOrder(root);
            return in+post;
        }

        private String inOrder(TreeNode root){
            ArrayList<Integer> ar = new ArrayList<>();
            inRec(root, ar);
            if(ar.size() == 0) return "";
            return Arrays.toString(ar.toArray()).substring(1);
        }
        
        private void inRec(TreeNode node, ArrayList<Integer> res){
            if(node == null) return;
            inRec(node.left,res);
            res.add(node.val);
            inRec(node.right,res);
        }
        
        private String postOrder(TreeNode root){
            ArrayList<Integer> ar = new ArrayList<>();
            postRec(root, ar);
            if(ar.size() == 0) return "";
            return Arrays.toString(ar.toArray()).substring(1);
        }
        private void postRec(TreeNode node, ArrayList<Integer> res){
            if(node == null) return;
            postRec(node.left,res);
            postRec(node.right,res);
            res.add(node.val);
        }
    

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if("".equals(data)) return null;
            String[] inpost = data.split("]");
            String[] arIn = inpost[0].split(",");
            String[] arPost = inpost[1].split(",");


            return buildTree(convert(arIn),convert(arPost));
        }

        private int[] convert(String[] ar){
            int[] res = new int[ar.length];
            for(int i = 0; i<ar.length; i++){
                res[i] = Integer.parseInt(ar[i].trim());
            }
            return res;
        }


        Map<Integer, Integer> inMap = new HashMap<>();
        int idx = 0;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++)
                inMap.put(inorder[i], i);
            idx = postorder.length - 1;
            return recur(postorder, 0, postorder.length - 1);
        }

        private TreeNode recur(int[] postorder, int l, int r) {
            if (l > r)
                return null;
            TreeNode root = new TreeNode(postorder[idx--]);
            root.right = recur(postorder, inMap.get(root.val) + 1, r);
            root.left = recur(postorder, l, inMap.get(root.val) - 1);
            return root;
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        Codec code = new Codec();
        String seri = code.serialize(root);
        TreeNode test = code.deserialize(seri);

    }
}
