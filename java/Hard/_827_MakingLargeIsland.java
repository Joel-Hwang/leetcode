package Hard;

import java.util.HashMap;

import org.testng.annotations.Test;
/*
maxArea에 현 시점 가장 큰 섬 크기 저장
섬들 돌면서 그 섬에다 번호(index)를 매기면서 섬 값을 1에서 번호로 변경하고 해쉬로 저장
해쉬에는 섬 인덱스 : 섬의 크기 저장

다시 grid 돌면서 0을 만나면 0과 상하좌우에 인접한 섬의 인덱스를 해쉬에서 찾아서 합산하기
최대값 리턴
*/
public class _827_MakingLargeIsland {
    public int largestIsland(int[][] grid) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxArea = getLargest(grid, hm);
        if (maxArea == 0)
            return 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int cur = 1;
                    boolean[] veSeen = new boolean[hm.size() + 2];
                    if (i + 1 >= 0 && i + 1 < grid.length && j >= 0 && j < grid[0].length
                            && !veSeen[grid[i + 1][j]]) {
                        cur += hm.getOrDefault(grid[i + 1][j], 0);
                        veSeen[grid[i + 1][j]] = true;
                    }
                    if (i - 1 >= 0 && i - 1 < grid.length && j >= 0 && j < grid[0].length
                            && !veSeen[grid[i - 1][j]]) {
                        cur += hm.getOrDefault(grid[i - 1][j], 0);
                        veSeen[grid[i - 1][j]] = true;
                    }
                    if (i >= 0 && i < grid.length && j + 1 >= 0 && j + 1 < grid[0].length
                            && !veSeen[grid[i][j + 1]]) {
                        cur += hm.getOrDefault(grid[i][j + 1], 0);
                        veSeen[grid[i][j + 1]] = true;
                    }
                    if (i >= 0 && i < grid.length && j - 1 >= 0 && j - 1 < grid[0].length
                            && !veSeen[grid[i][j - 1]]) {
                        cur += hm.getOrDefault(grid[i][j - 1], 0);
                        veSeen[grid[i][j - 1]] = true;
                    }

                    maxArea = Math.max(maxArea, cur);

                }
            }
        }

        return maxArea;
    }

    private int getLargest(int[][] grid, HashMap<Integer, Integer> hm) {
        int maxArea = 0;
        int index = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    Ref ref = new Ref(0);
                    rec(i, j, grid, 0, ref, index);
                    hm.put(index++, ref.val);
                    maxArea = Math.max(maxArea, ref.val);
                }
            }
        }
        return maxArea;
    }

    private void rec(int i, int j, int[][] grid, int dir, Ref ref, int index) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length)
            return;
        if (grid[i][j] == 1) {
            ref.val++;
            grid[i][j] = index;
            if (dir != 2)
                rec(i + 1, j, grid, 1, ref, index);
            if (dir != 1)
                rec(i - 1, j, grid, 2, ref, index);
            if (dir != 4)
                rec(i, j + 1, grid, 3, ref, index);
            if (dir != 3)
                rec(i, j - 1, grid, 4, ref, index);
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
    public void test() {
        System.out.println(largestIsland(new int[][] { { 1, 1 }, { 1, 0 } }));
        System.out.println(largestIsland(new int[][] { { 1, 0 }, { 0, 1 } }));
        System.out.println(largestIsland(new int[][] { { 1, 1 }, { 1, 1 } }));
    }
}

/*

import javafx.util.Pair;
class Solution {
    public int N = 0;
    public int largestIsland(int[][] grid) {
        N = grid.length;
        //DFS every island and give it an index of island
        int index = 3, res = 0;
        HashMap<Integer, Integer> area = new HashMap<>();
        for (int x = 0; x < N; ++x) for (int y = 0; y < N; ++y)
            if (grid[x][y] == 1) {
                area.put(index, dfs(grid, x, y, index));
                res = Math.max(res, area.get(index++));
            }

        //traverse every 0 cell and count biggest island it can conntect
        for (int x = 0; x < N; ++x) for (int y = 0; y < N; ++y)
            if (grid[x][y] == 0) {
                HashSet<Integer> seen = new HashSet<>();
                int cur = 1;
                for (Pair<Integer, Integer> p : move(x, y)) {
                    index = grid[p.getKey()][p.getValue()];
                    if (index > 1 && !seen.contains(index)) {
                        seen.add(index);
                        cur += area.get(index);
                    }
                }
                res = Math.max(res, cur);
            }
        return res;
    }

    public List <Pair<Integer, Integer>> move(int x, int y) {
        ArrayList <Pair<Integer, Integer>> res = new ArrayList<>();
        if (valid(x, y + 1)) res.add(new Pair<Integer, Integer>(x, y + 1));
        if (valid(x, y - 1)) res.add(new Pair<Integer, Integer>(x, y - 1));
        if (valid(x + 1, y)) res.add(new Pair<Integer, Integer>(x + 1, y));
        if (valid(x - 1, y)) res.add(new Pair<Integer, Integer>(x - 1, y));
        return res;
    }

    public boolean valid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public int dfs(int[][] grid, int x, int y, int index) {
        int area = 0;
        grid[x][y] = index;
        for (Pair<Integer, Integer> p : move(x, y))
            if (grid[p.getKey()][p.getValue()] == 1)
                area += dfs(grid, p.getKey(), p.getValue(), index);
        return area + 1;
    }
}

*/