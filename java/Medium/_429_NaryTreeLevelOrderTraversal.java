package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import CS.Node2;

public class _429_NaryTreeLevelOrderTraversal{
    public List<List<Integer>> levelOrder(Node2 root) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(root,0,res);

        return res;
    }

    private void dfs(Node2 node,int level, List<List<Integer>> res){
        if(node == null) return;
        if(res.size() <= level) res.add(new ArrayList<Integer>());
        List<Integer> curLevel = res.get(level);
        curLevel.add(node.val);
        for(int i = 0; node.children != null && i<node.children.size(); i++){
            dfs(node.children.get(i),level+1,res);
        }
        //curLevel.remove(curLevel.size()-1);
    }

    @Test
    public void test(){
        Node2 test = new Node2(1);
        test.children = new ArrayList<Node2>();
        test.children.add(new Node2(3));
        test.children.add(new Node2(2));
        test.children.add(new Node2(4));
        test.children.get(0).children = new ArrayList<Node2>();
        test.children.get(0).children.add(new Node2(5));
        test.children.get(0).children.add(new Node2(6));
        for(List<Integer> row : levelOrder(test)){
            System.out.println(Arrays.toString(row.toArray()));
        }
    }
}