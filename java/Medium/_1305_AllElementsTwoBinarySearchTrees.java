import java.util.List;

import CS.TreeNode;
import java.util.ArrayList;

public class _1305_AllElementsTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        setList(root1,r1);
        setList(root2,r2);

        int c1=0,c2=0;
        int max = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<r1.size()+r2.size(); i++){
            int i1 = c1>=r1.size()?max:r1.get(c1);
            int i2 = c2>=r2.size()?max:r2.get(c2);
            if(i1 < i2){
                res.add(i1);
                c1++;
            }else{
                res.add(i2);
                c2++;
            }
        }
        return res;
    }

    private void setList(TreeNode node, List<Integer> res){
        if(node == null) return;
        setList(node.left, res);
        res.add(node.val);
        setList(node.right, res);
    }

    
}
