package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class _778_SwiminRisingWater {

    public int swimInWater(int[][] grid){
        int n = grid.length;
        int l = grid[0][0];
        int r = n*n-1;
        while(l<r){
            int m = (l+r)/2;
            if(dfs(grid, 0, 0, m, new boolean[n][n])){
                r = m;
            }else{
                l = m+1;
            }
        }
        return l;
    }
    //T값을 최대값으로 봤을 때 0,0에서 마지막까지 도달할 수 있는지 보자
    //도달했다면 T를 절반으로 줄여서 또 도달했는지 보자.
    //절반으로 줄여서 도달 못했다면 T를 조금만 늘려서(1/2만큼) 도달하는지 보자. 
    //계속 반복
    private boolean dfs(int[][] grid, int i, int j, int T, boolean[][] visited){
        int n = grid.length;
        if(i< 0 || i>=n || j <0 || j>=n || visited[i][j] || grid[i][j] > T) return false;
        visited[i][j] = true;
        if(i == n-1 && j == n-1) return true;
        return dfs(grid, i-1, j, T, visited) || dfs(grid, i+1, j, T, visited) || dfs(grid, i, j-1, T, visited) || dfs(grid, i, j+1, T, visited);
    }



    int curAnswer = Integer.MAX_VALUE;
    public int swimInWater2(int[][] grid) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(grid[0][0]);
        return dfs2(set,grid,0,0, grid[0][0]);
    }

    private int dfs2(Set<Integer> set, int[][] grid, int pI, int pJ, int maxVal){
        if(grid[pI][pJ] >= curAnswer) return -1;
        if(pI == grid.length-1 && pJ == grid.length-1){
            curAnswer = Math.min(curAnswer,maxVal);
            return maxVal;
        }

        boolean ableT = pI-1>=0 && !set.contains(grid[pI-1][pJ]);
        boolean ableB = pI+1<grid.length && !set.contains(grid[pI+1][pJ]);
        boolean ableL = pJ-1>=0 && !set.contains(grid[pI][pJ-1]);
        boolean ableR = pJ+1<grid.length && !set.contains(grid[pI][pJ+1]);
        
        int disT = -1,disB = -1,disL = -1,disR = -1;
        if(ableT){
            int val = grid[pI-1][pJ];
            set.add(val);
            int ownMax = Math.max(maxVal, val);
            disT = dfs2(set,grid,pI-1,pJ, ownMax);
            set.remove(val);
        }
        if(ableB){
            int val = grid[pI+1][pJ];
            set.add(val);
            int ownMax = Math.max(maxVal, val);
            disB = dfs2(set,grid,pI+1,pJ, ownMax);
            set.remove(val);
        }
        if(ableL){
            int val = grid[pI][pJ-1];
            set.add(val);
            int ownMax = Math.max(maxVal, val);
            disL = dfs2(set,grid,pI,pJ-1, ownMax);
            set.remove(val);
        }
        if(ableR){
            int val = grid[pI][pJ+1];
            set.add(val);
            int ownMax = Math.max(maxVal, val);
            disR = dfs2(set,grid,pI,pJ+1, ownMax);
            set.remove(val);
        }

        if(!ableT && !ableB && !ableL && !ableR) return -1;
        return min(disT, disB,disL,disR);
    }

    private int min(int... a){
        int res = Integer.MAX_VALUE;
        for(int i = 0; i<a.length; i++){
            if(a[i]<0) continue;
            res = Math.min(res,a[i]);
        }
        return res;
    }


    @Test
    public void test(){
        assertEquals(29, swimInWater(new int[][]{{29,28,12, 2,24,11},
                                                 {17,30,25, 9,13,33},
                                                 { 1, 0,34,35,23,19},
                                                 {31,22, 4,26, 6, 3},
                                                 {21,14,15, 8,32,20},
                                                 { 5,18, 7,27,16,10}}));

        assertEquals(16, swimInWater(new int[][]{{ 0, 1, 2, 3, 4},
                                                 {24,23,22,21, 5},
                                                 {12,13,14,15,16},
                                                 {11,17,18,19,20},
                                                 {10, 9, 8, 7, 6}}));
        assertEquals(3, swimInWater(new int[][]{{0,1},{2,3}}));
    }

    
}
