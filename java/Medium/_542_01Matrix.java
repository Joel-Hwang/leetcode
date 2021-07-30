package Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.testng.annotations.Test;

public class _542_01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = -1;
            }
        }
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0){
                    q.add(new Node(i, j, 0));
                }

            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            if(node.i<0 || node.j<0 || node.i>=mat.length || node.j >= mat[0].length) continue;
            if(res[node.i][node.j] > -1) continue;
            res[node.i][node.j] = node.val;
            q.add(new Node(node.i + 1, node.j, node.val + 1));
            q.add(new Node(node.i - 1, node.j, node.val + 1));
            q.add(new Node(node.i, node.j + 1, node.val + 1));
            q.add(new Node(node.i, node.j - 1, node.val + 1));
        }
        return res;
    }

    class Node {
        int i, j, val;

        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    @Test
    public void test() {
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 0,0,0 } };
        int[][] res = updateMatrix(mat);
        for (int i = 0; i < res.length; i++)
            System.out.println(Arrays.toString(res[i]));
    }
}
