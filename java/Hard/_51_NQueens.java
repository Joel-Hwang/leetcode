package Hard;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        String[][] map = new String[n][n];
        solve(map, n, res);

        return res;
    }

    public void solve(String[][] map, int n, List<List<String>> res) {
        
        if (n == 0) {
            ArrayList<String> cs = new ArrayList<String>();
            for (int i = 0; i < map.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < map[i].length; j++) {
                    sb.append("Q".equals(map[i][j])?"Q":".");
                }
                cs.add(sb.toString());
            }
            res.add(cs);
            return;
        }
        
        for (int j = 0; j < map.length; j++) {
            if (setQ(map, n-1, j, ""+n)) {
                solve(map, n - 1, res);
                unset(map,n-1,j,""+n);
            }
            
        }
    }

    public boolean setQ(String[][] map, int y, int x, String n) {
        boolean res = true;
        if (map[y][x] != null)
            return false;

        map[y][x] = "Q";

        for (int i = 0; i < map.length; i++) {
            if (map[y][i] == null)
                map[y][i] = n;
            if (map[i][x] == null)
                map[i][x] = n;

            if (y - i >= 0 && x - i >= 0 && map[y - i][x - i] == null)
                map[y - i][x - i] = n;
            if (y + i < map.length && x + i < map.length && map[y + i][x + i] == null)
                map[y + i][x + i] = n;
            if (y + i < map.length && x - i >=0 && map[y + i][x - i] == null)
                map[y + i][x - i] = n;
            if (y - i >= 0 && x + i < map.length && map[y - i][x + i] == null)
                map[y - i][x + i] = n;
        }

        return res;
    }

    public void unset(String[][] map, int y, int x, String n){
        map[y][x] = null;
        for(int i = 0; i<map.length; i++)
            for(int j = 0; j< map[i].length; j++)
                if(n.equals(map[i][j])) map[i][j] = null;
    }

    @Test
    public void test() {
        solveNQueens(4);
    }
}
