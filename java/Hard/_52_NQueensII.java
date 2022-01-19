package Hard;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _52_NQueensII {
    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        String[][] map = new String[n][n];
        solve(map, n, res);

        return res.size();
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


    int ans;
    
    /**
    
    (Note: This problem is an easier duplicate to the previous problem, 51: N-Queens, 
    except that it doesn't require us to return the actual boards, just the count.)

A naive approach here would attempt every possible combination of locations, 
but there are (N^2)! / (N^2 - N)! different combinations, 
which is up to ~1e17 when N = 9. 
Instead, we need to make sure we only attempt to place queens 
where it's feasible to do so, based on the instructions. 
This would seem to call for a depth first search (DFS) approach with a recursive helper function (place), 
so that we only pursue workable combinations without wasting time on known dead-ends.

First, we should consider how the queens will be placed. 
Since each row can only have one queen, our basic process will be to place 
a queen and then recurse to the next row. 
On each row, we'll have to iterate through the possible options, 
check the cell for validity, then place the queen on the board.

Rather than store the whole board, 
we can save on space complexity if we only keep track of the different axes of attack 
in which a queen might be placed. Since a queen has four axes of attack, 
we'll need to check the three remaining axes 
(other than the horizontal row, which our iteration will naturally take care of) for validity.

There are N possible columns and 2 * N - 1 possible left-downward di agonals 
and right-downward diagonals. 
With a constraint of 1 <= N <= 9, each of the two diagonal states represents up to 17 bits' 
worth of data and the vertical state up to 9 bits, 
so we can use bit manipulation to store these states efficiently.

So for each recursive call to place a queen, we should pass along the board state 
in the form of only three integers (vert, ldiag, rdiag). 
We can then use bitmasks to check for cell validity before attempting to recurse to the next row.

If we successfully reach the end of the board without failing, we should increment our answer counter (ans).

Time Complexity: O(N!) which represents the maximum number of queens placed
Space Complexity: O(N) for the recursion stack

     */
    public int totalNQueens2(int N) {
        ans = 0;
        place(0,0,0,0,N);
        return ans;
    }
    
    private void place(int i, int vert, int ldiag, int rdiag, int N) {
        if (i == N) ans++;
        else for (int j = 0; j < N; j++) {
            int vmask = 1 << j, lmask = 1 << (i+j), rmask = 1 << (N-i-1+j);
            if ((vert & vmask) + (ldiag & lmask) + (rdiag & rmask) > 0) continue;
            place(i+1, vert | vmask, ldiag | lmask, rdiag | rmask, N);
        }
    }

    @Test
    public void test(){
        System.out.println(totalNQueens(1));
        System.out.println(totalNQueens(4));
    }
}
