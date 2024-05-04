package Hard;

import java.util.*;

import org.testng.annotations.Test;


public class _1483_KthAncestorOfaTreeNode {
    class TreeAncestor {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        public TreeAncestor(int n, int[] parent) {
            
            Map<Integer, List<Integer>> tree = getTree(parent);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            while(!queue.isEmpty()){
                int directParent = queue.peek();
                List<Integer> followers = tree.get(directParent);
                queue.poll();
                if(followers == null) continue;
                for(int follower: followers){
                    queue.add(follower);
                    setMap(follower, directParent);
                }
            }

            map.put(0,new ArrayList<>());
            for(int i = 1; i<n; i++){
                
            }
        }
        
        public int getKthAncestor(int node, int k) {
            List<Integer> ancestors = map.get(node);
            if(k<1 || ancestors.size() == 0) return -1;
            if(k==1)
                return ancestors.get(0);

            int idxOfClosestParent = log(k)-1;
            if(idxOfClosestParent >= ancestors.size()) return -1;
            return this.getKthAncestor(ancestors.get(idxOfClosestParent),(int)(k-Math.pow(2,idxOfClosestParent)));
        }

        private int log(int k){
            return (int)(Math.log(k)/Math.log(2));
        }

        private void setMap(int follower, int parent){
            List<Integer> ancestors = new ArrayList<>();
            int nthParent = parent;
            ancestors.add(nthParent);
            int idx = 0;
            while(true){
                List<Integer> nthParentAncestors = map.get(nthParent);
                int jump = idx++;
                if(nthParentAncestors == null || nthParentAncestors.size()<=jump) break;
                int nextAncestor = nthParentAncestors.get(jump);
                ancestors.add(nextAncestor);
                nthParent = nextAncestor;
            }
            map.put(follower, ancestors);
        }

        private Map<Integer, List<Integer>> getTree(int[] parent){
            Map<Integer, List<Integer>> tree = new HashMap<>();
            for(int i = 0; i<parent.length; i++){
                List<Integer> list = tree.getOrDefault(parent[i], new ArrayList<>());
                list.add(i);
                tree.put(parent[i], list);
            }
            return tree;
        }
    }

    @Test
    public void test(){
        TreeAncestor ta = null;
        ta = new TreeAncestor(6, new int[]{-1,2,3,4,5,0});
        System.out.println(ta.getKthAncestor(1, 4));

        ta = new TreeAncestor(5, new int[]{-1,0,0,0,3});
        System.out.println(ta.getKthAncestor(1, 5));
        System.out.println(ta.getKthAncestor(3, 2));
        System.out.println(ta.getKthAncestor(0, 1));
        System.out.println(ta.getKthAncestor(3, 1));
        System.out.println(ta.getKthAncestor(3, 5));



        ta = new TreeAncestor(11, new int[]{-1,0,1,2,3,4,5,6,7,8,9,10});
        System.out.println(ta.getKthAncestor(10, 1));
        System.out.println(ta.getKthAncestor(10, 2));
        System.out.println(ta.getKthAncestor(10, 3));
        System.out.println(ta.getKthAncestor(10, 4));
        System.out.println(ta.getKthAncestor(10, 5));
        System.out.println(ta.getKthAncestor(10, 6));
        System.out.println(ta.getKthAncestor(10, 7));
        System.out.println(ta.getKthAncestor(10, 8));
        System.out.println(ta.getKthAncestor(10, 9));
        System.out.println(ta.getKthAncestor(10, 10));
        
        ta = new TreeAncestor(7, new int[]{-1,0,0,1,1,2,2});
        System.out.println(ta.getKthAncestor(3, 1));
        System.out.println(ta.getKthAncestor(5, 2));
        System.out.println(ta.getKthAncestor(6, 3));

    }
}
