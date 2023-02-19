package Easy;

import java.util.*;

import CS.*;

public class _589_N_aryTreePreorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node2 root) {
        if(root == null) return res;
        res.add(root.val);
        for(Node2 children : root.children){
            preorder(children);
        }
        return res;
    }
}
