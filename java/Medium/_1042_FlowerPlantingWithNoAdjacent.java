package Medium;
import java.util.*;

import org.testng.annotations.Test;

public class _1042_FlowerPlantingWithNoAdjacent{
    public int[] gardenNoAdj1(int n, int[][] paths) {
        int[] res = new int[n+1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] path : paths){
            for(int p : path)
                if(!map.containsKey(p))
                    map.put(p, new HashSet<Integer>());
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }

        for(int[] path :paths){
            for(int p : path){
                if(res[p] == 0){
                    for(int node : map.get(p)){
                        setValue(map,res,node);
                    }
                    setValue(map, res, p);
                }
            }
        }

        for(int i = 0; i<res.length; i++)
            if(res[i] == 0) res[i] = 1;
        return Arrays.copyOfRange(res, 1, res.length);
    }

    private void setValue(Map<Integer, Set<Integer>> map, int[] res, int n){
        if(res[n] == 0){
            res[n] = getAvailable(map, res, n);
        }
    }

    private int getAvailable(Map<Integer, Set<Integer>> map, int[] res, int n){
        Set<Integer> set = map.get(n);
        int[] type = {0,1,2,3,4};
        for(int node : set){
            type[res[node]] = 0; 
        }
        for(int t : type)
            if(t>0) return t;
        return 0;
    }

    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> G = new HashMap<>();
        for (int i = 0; i < N; i++) G.put(i, new HashSet<>());
        for (int[] p : paths) {
            G.get(p[0] - 1).add(p[1] - 1);
            G.get(p[1] - 1).add(p[0] - 1);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int[] colors = new int[5];
            for (int j : G.get(i))
                colors[res[j]] = 1;
            for (int c = 4; c > 0; --c)
                if (colors[c] == 0)
                    res[i] = c;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(gardenNoAdj(1, new int[][]{})));
        System.out.println(Arrays.toString(gardenNoAdj(3, new int[][]{{1,2},{2,3},{3,1}})));
    }
}