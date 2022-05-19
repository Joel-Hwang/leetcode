package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.testng.annotations.Test;

public class _1091_ShortestPathBinaryMatrix{
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;
        Queue<int[]> list = new LinkedList<int[]>();
        int[][] dist = new int[grid.length][grid[0].length];
        dist[0][0] = 1;
        list.add(new int[]{0,0});
        while(!list.isEmpty()){
            int n = list.size();
            for(int i = 0; i<n; i++){
                int[] cur = list.poll();
                setNext(cur[0],cur[1],grid,dist,list);
            }
        }
        return dist[grid.length-1][grid[0].length-1]==0?-1:dist[grid.length-1][grid[0].length-1];        
    }

    private void setNext(int y, int x, int[][] grid, int[][] dist,Queue<int[]> list){
        int nextStep = dist[y][x] + 1;
        for(int i = y-1; i<=y+1; i++){
            if(i < 0) continue;
            if(i >= grid.length) continue;

            for(int j = x-1; j<=x+1; j++){
                if(i == y && j == x) continue;
                if(j < 0) continue;
                if(j >= grid[0].length) continue;
                if(grid[i][j] == 1) continue;

                if(dist[i][j]== 0){
                    dist[i][j] = nextStep;
                    list.add(new int[]{i,j});
                } 
                //else dist[i][j] = Math.max(dist[i][j], nextStep);
                
            }
        }
    }

    @Test
    public void test(){
        int[][] grid = {
            {0,0,0,0,0},
            {1,1,1,1,0},
            {1,1,1,1,0},
            {1,1,1,1,0},
            {1,1,1,1,0}

        };

        shortestPathBinaryMatrix(grid);
    }



}