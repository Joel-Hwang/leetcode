package Easy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.testng.annotations.Test;

public class _867_TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                res[j][i] = matrix[i][j];
        return res;
    }

    @Test
    public void test(){
        assertArrayEquals(new int[][]{{1,4,7},{2,5,8},{3,6,9}}, transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
