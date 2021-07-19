package Hard;

import javax.security.auth.x500.X500Principal;

import org.testng.annotations.Test;

public class _85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0) continue;
                res = Math.max(res, getSize(i, j, matrix));
            }
        }
        return res;
    }

    private int getSize(int i, int j, char[][] matrix) {
        if (matrix[i][j] == 0)
            return 0;
        int res = 0;
        int xlen = matrix[0].length;
        int ylen = matrix.length;
        for (int y = i; y < ylen; y++) {
            for (int x = j; x < xlen; x++) {
                if (matrix[y][x] == '0') {
                    xlen = x;
                    res = Math.max(res, (y - i + 1) * (x - j));
                }else if(x == xlen - 1){
                    xlen = x+1;
                    res = Math.max(res, (y - i + 1) * (x - j + 1));
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalRectangle(matrix));
        System.out.println(maximalRectangle(new char[][]{{'0'}}));
        System.out.println(maximalRectangle(new char[][]{{}}));
        System.out.println(maximalRectangle(new char[][]{{'1'}}));
        System.out.println(maximalRectangle(new char[][]{{'0','0'}}));
        // System.out.println(getSize(0, 0, matrix));
        // System.out.println(getSize(0, 2, matrix));
        // System.out.println(getSize(1, 2, matrix));
        // System.out.println(getSize(2, 0, matrix));
        // System.out.println(getSize(2, 1, matrix));
    }
}
