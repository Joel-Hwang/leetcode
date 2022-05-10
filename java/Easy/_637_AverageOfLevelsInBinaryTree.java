package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import CS.TreeNode;

public class _637_AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            double avg = 0;
            for(int i = 0; i < n; i++){
                TreeNode cur = q.poll();
                if(cur.left != null)  q.add(cur.left);
                if(cur.right != null)q.add(cur.right);
                avg += cur.val;
            }
            avg/=n;
            result.add(avg);
        }
        return result;
    }
}
