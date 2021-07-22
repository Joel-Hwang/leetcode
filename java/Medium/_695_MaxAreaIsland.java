package Medium;

import org.testng.annotations.Test;

public class _695_MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] map = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !map[i][j]) {
                    Ref cur = new Ref(0);
                    checkIsland(i, j, grid, map, cur);
                    res = Math.max(res, cur.value);
                }
            }
        }

        return res;
    }

    private void checkIsland(int i, int j, int[][] grid, boolean[][] map, Ref cur) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] != 1 || map[i][j])
            return;

        map[i][j] = true;
        cur.value++;
        checkIsland(i - 1, j, grid, map, cur);
        checkIsland(i + 1, j, grid, map, cur);
        checkIsland(i, j - 1, grid, map, cur);
        checkIsland(i, j + 1, grid, map, cur);
    }

    class Ref{
        int value;
        Ref(int value){
            this.value = value;
        }
    }

    @Test
    public void test(){
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }

}
