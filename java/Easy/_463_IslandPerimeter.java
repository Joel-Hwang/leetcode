package Easy;

public class _463_IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                int cur = 4;
                if (i - 1 >= 0 && grid[i - 1][j] == 1)
                    cur--;
                if (i + 1 < grid.length && grid[i + 1][j] == 1)
                    cur--;
                if (j - 1 >= 0 && grid[i][j - 1] == 1)
                    cur--;
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1)
                    cur--;
                res += cur;
            }
        }
        return res;
    }
}
