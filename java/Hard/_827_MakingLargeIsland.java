package Hard;

import org.testng.annotations.Test;

public class _827_MakingLargeIsland {
    public int largestIsland(int[][] grid) {
        int maxArea = getLargest(grid);
        //if(maxArea == 0) return 1;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 0 && isConnected(i,j,grid)){
                    grid[i][j] = 1;
                    boolean[][] flags = new boolean[grid.length][grid[0].length];
                    Ref ref = new Ref(0);
                    rec(i, j, grid, flags, 0, ref);
                    maxArea = Math.max(maxArea, ref.val);
                    grid[i][j] = 0;
                }
            }
        }

        return maxArea;
    }
    private boolean isConnected(int i, int j, int[][] grid){
        if(i+1>=0 && i+1<grid.length && j>=0 && j<grid[0].length && grid[i+1][j] == 1) return true;
        if(i-1>=0 && i-1<grid.length && j>=0 && j<grid[0].length && grid[i-1][j] == 1) return true;
        if(i>=0 && i<grid.length && j+1>=0 && j+1<grid[0].length && grid[i][j+1] == 1) return true;
        if(i>=0 && i<grid.length && j-1>=0 && j-1<grid[0].length && grid[i][j-1] == 1) return true;

        return false;
    }
    private int getLargest(int[][] grid) {
        boolean[][] flags = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !flags[i][j]) {
                    Ref ref = new Ref(0);
                    rec(i, j, grid, flags, 0, ref);
                    maxArea = Math.max(maxArea, ref.val);
                }
            }
        }
        return maxArea;
    }

    private void rec(int i, int j, int[][] grid, boolean[][] flags, int dir, Ref ref) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length)
            return;
        if (grid[i][j] == 1 && !flags[i][j]) {
            ref.val++;
            flags[i][j] = true;
            if (dir != 2)
                rec(i + 1, j, grid, flags, 1, ref);
            if (dir != 1)
                rec(i - 1, j, grid, flags, 2, ref);
            if (dir != 4)
                rec(i, j + 1, grid, flags, 3, ref);
            if (dir != 3)
                rec(i, j - 1, grid, flags, 4, ref);
        }
        return;
    }

    class Ref {
        int val;

        public Ref(int val) {
            this.val = val;
        }
    }



    @Test
    public void test(){
        System.out.println(largestIsland(new int[][]{{1,0},{0,1}}));
        System.out.println(largestIsland(new int[][]{{1,1},{1,0}}));
        System.out.println(largestIsland(new int[][]{{1,1},{1,1}}));
    }
}