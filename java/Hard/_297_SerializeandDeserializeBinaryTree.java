package Hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.testng.annotations.Test;

import CS.TreeNode;

public class _297_SerializeandDeserializeBinaryTree {
    public class Codec {
        int gId = 0;
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "";
            StringBuilder sb = new StringBuilder();
            recSerial(sb, root, -1, 0);
            return sb.toString().substring(1);
        }

        private void recSerial(StringBuilder sb,TreeNode node, int pId, int lr){
            if(node == null) return;
            int id = gId++;
            int val = node.val;
            String cur = String.format("%d:%d:%d:%d", id,val,pId,lr);
            sb.append(",");
            sb.append(cur);
            recSerial(sb, node.left, id, 0);
            recSerial(sb, node.right, id, 1);
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if("".equals(data)) return null;
            TreeNode root = new TreeNode(-1);
            HashMap<Integer,TreeNode> map = new HashMap<>();
            map.put(-1, root);
            String[] rows = data.split(",");
            for(String row : rows){
                String[] elems = row.split(":");
                int id = Integer.parseInt(elems[0]);
                int val = Integer.parseInt(elems[1]);
                int pId = Integer.parseInt(elems[2]);
                int lr = Integer.parseInt(elems[3]);
                TreeNode node = new TreeNode(val);
                map.put(id, node);
                TreeNode p = map.get(pId);
                if(lr == 0) p.left = node;
                else p.right = node;
            }
            return root.left;
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(new Integer[]{1,2,3,null,null,4,5});
        root = new TreeNode(new Integer[]{1});
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(root));
        System.out.println(ans.toString());
    }
}
