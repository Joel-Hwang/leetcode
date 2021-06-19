package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _59_Spiral_MatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int i = 0, j = 0;
        int arrow = 0;

        for (int cnt = 1; cnt <= n * n; cnt++) {
            res[i][j] = cnt;

            switch (arrow % 4) {
                case 0: // left
                    if (j == n - 1 || res[i][j + 1] > 0) {
                        arrow++;
                        i++;
                    } else
                        j++;
                    break;
                case 1: // bottom
                    if (i == n - 1 || res[i + 1][j] > 0) {
                        arrow++;
                        j--;
                    } else
                        i++;
                    break;
                case 2: // right
                    if (j == 0 || res[i][j - 1] > 0) {
                        arrow++;
                        i--;
                    } else
                        j--;
                    break;
                case 3: // up
                    if (i == 0 || res[i - 1][j] > 0) {
                        arrow++;
                        j++;
                    } else
                        i--;
                    break;
            }
        }

        return res;
    }

    @Test
    public void test(){
        int[][] r1 = generateMatrix(1);
        for(int[] r : r1) System.out.println(Arrays.toString(r));
    }
}


