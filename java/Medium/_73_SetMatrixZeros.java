package Medium;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

public class _73_SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        ArrayList<int[]> ar = new ArrayList<>();
        for(int i = 0; i<matrix.length; i++)
            for(int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    ar.add(new int[]{i,j});
                }
            }

        for(int[] row : ar){
            for(int i = 0; i<matrix.length; i++){
                matrix[i][row[1]] = 0;    
            }
            for(int i = 0; i<matrix[0].length; i++){
                matrix[row[0]][i] = 0;    
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        
    }

    @Test
    public void test(){
        int[][] m1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(m1);
        for(int[] r :m1){
            System.out.println(Arrays.toString(r));
        }
    }
}
