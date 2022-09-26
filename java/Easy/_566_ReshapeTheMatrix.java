package Easy;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _566_ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != mat.length*mat[0].length) return mat;
        int[] single = new int[r*c];
        int singlePoint = 0;
        
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[i].length; j++)
                single[singlePoint++] = mat[i][j];
        
        int[][] res = new int[r][c];
        singlePoint = 0;
        for(int i = 0; i<res.length; i++) {
            for(int j = 0; j<res[i].length; j++){
                res[i][j] = single[singlePoint++];
            }
        }
        return res;
    }

    @Test
    public void test(){
        matrixReshape(new int[][]{{1,2},{3,4}}, 2, 2);
    }
}
