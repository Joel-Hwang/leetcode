package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        //list index : index를 먼저 듣고 나중에 들어야 하는 과목들
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i<numCourses; i++) map.put(i,new ArrayList<>());
        for(int[] pre : prerequisites) map.get(pre[1]).add(pre[0]);
        
        while(map.size()>0){
            if(bfs(map,res)<0) return new int[0];
        }

        int[] result = new int[numCourses];
        for(int i = 0; i<result.length; i++) result[i] = res.get(res.size()-1-i);
        return result;
    }

    private int bfs(Map<Integer,List<Integer>> map, List<Integer> res){
        for(int i : map.keySet()){
            if(map.get(i).size() == 0){
                res.add(i);
                removeCurIndex(map, i);                
                map.remove(i);
                return i;
            }
        }
        return -1;
    }

    private void removeCurIndex(Map<Integer,List<Integer>> map, int n){
        for(int i : map.keySet()){
            for(int j = map.get(i).size()-1; j>=0; j--){
                if(map.get(i).get(j) == n) map.get(i).remove(j);
            }
        }
    }

    @Test
    public void test(){
        findOrder(4, new int[][]{{0,1},{0,2},{1,3},{2,3}});
    }
}
