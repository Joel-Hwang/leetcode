package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.testng.annotations.Test;

public class _310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 2) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++)
                res.add(i);
            return res;
        }

        List<HashSet<Integer>> paths = new ArrayList<>();
        for(int i = 0; i<n; i++) paths.add(new HashSet<Integer>());
        for (int[] edge : edges) {
            paths.get(edge[0]).add(edge[1]);
            paths.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < paths.size(); i++) {
            if (paths.get(i).size() == 1)
                leaves.add(i);
        }

        while (n > 2) {
            int leaveSize = leaves.size();
            n -= leaveSize;
            List<Integer> newLeaves = new ArrayList<>();
            for (int i = 0; i < leaveSize; i++) {
                int leave = leaves.get(i);
                int newNode = paths.get(leave).iterator().next();
                paths.get(newNode).remove(leave);
                if (paths.get(newNode).size() == 1)
                    newLeaves.add(newNode);
            }
            leaves = newLeaves;

        }
        return leaves;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(
                findMinHeightTrees(3, new int[][] { {0, 1 }, { 0, 2 } }).toArray()));
               // findMinHeightTrees(6, new int[][] { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } }).toArray()));

    }
}
