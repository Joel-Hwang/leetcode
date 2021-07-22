package Medium;

import org.testng.annotations.Test;

//AC 알고리즘???
public class _200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        boolean[][] map = new boolean[grid.length][grid[0].length];
        int res = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !map[i][j]){
                    checkIsland(i,j,grid,map);
                    res++;
                }
            }
        }

        return res;
    }

    private void checkIsland(int i, int j, char[][] grid, boolean[][] map){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;
        if(grid[i][j] != '1' || map[i][j]) return;
        
        map[i][j] = true;
        checkIsland(i-1, j, grid, map);
        checkIsland(i+1, j, grid, map);
        checkIsland(i, j-1, grid, map);
        checkIsland(i, j+1, grid, map);
    }


    @Test
    public void test(){
       char[][] grid = {
        {'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}
      };
      System.out.println(numIslands(grid));
    }
}
