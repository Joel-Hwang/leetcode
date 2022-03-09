package Medium;

import java.util.*;

import org.testng.annotations.Test;


public class _207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] pToC = new ArrayList[numCourses];
        ArrayList<Integer>[] cToP = new ArrayList[numCourses];
        for(int i = 0; i<pToC.length; i++){
            pToC[i] = new ArrayList<>();
            cToP[i] = new ArrayList<>();
        }
        for(int[] course : prerequisites){
            pToC[course[1]].add(course[0]);
            cToP[course[0]].add(course[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> order = new ArrayList<>();
        for(int i = 0; i<pToC.length; i++){
            if(pToC[i].size() == 0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int c = q.poll();
            order.add(c);
            for(int p : cToP[c]){
                pToC[p].remove((Integer)c);
                if(pToC[p].size() == 0) q.add(p);
            }
        }

        return order.size() == numCourses;
    }

    

    

    @Test
    public void test(){
        System.out.println(canFinish(6, new int[][]{{0,1},{0,2},{2,3},{3,1},{1,5},{3,4}}));
    }
}