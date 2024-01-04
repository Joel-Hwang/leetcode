package Hard;

import java.util.*;

import org.testng.annotations.Test;
public class _1377_FrogPositionAfterTSeconds {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        double res = 1;
        Queue<FrogNode> q = new LinkedList<>();
        FrogNode root = generateTree(n,edges);
        q.add(root);
        while(q.isEmpty() == false){
            FrogNode current = q.poll();
            if(current.val == target){
                if(current.level == t) return current.ratio;
                if(current.level < t && current.children.size()==0) return current.ratio;
                return 0;
            }

            for(FrogNode child : current.children){
                q.add(child);
            }
        }
        return res;
    }

    private FrogNode generateTree(int n, int[][] edges){
        boolean[] touchedVertice = new boolean[n+1];
        Queue<FrogNode> q = new LinkedList<>();
        touchedVertice[1] = true;
        FrogNode root = new FrogNode(1, 1,0);
        q.add(root);
        while(q.isEmpty() == false){
            FrogNode current = q.poll();
            List<Integer> children = findChildren(current.val, edges, touchedVertice);
          
            for(int child : children){
                FrogNode frongChild = new FrogNode(child, current.ratio*1/children.size(),current.level+1);
                current.children.add(frongChild);
                touchedVertice[child] = true;
                q.add(frongChild);
            }
        }
        return root;
    }

    private List<Integer> findChildren(int n, int[][] edges, boolean[] touchedVertice){
        List<Integer> res = new ArrayList<>();
        for(int[] edge: edges){
            if(edge[0] == n && touchedVertice[edge[1]]==false) res.add(edge[1]);
            if(edge[1] == n && touchedVertice[edge[0]]==false) res.add(edge[0]);
        }
        return res;
    }

    class FrogNode{
        int val;
        int level;
        double ratio;
        List<FrogNode> children;
        public FrogNode(int val, double ratio, int level){
            this.val = val;
            this.ratio = ratio;
            this.level = level;
            children = new ArrayList<>();
        }
    }

    @Test
    public void test(){
        System.out.println(frogPosition(7, new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}}, 2, 4));
        System.out.println(frogPosition(7, new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}}, 1, 7));
    }
}
