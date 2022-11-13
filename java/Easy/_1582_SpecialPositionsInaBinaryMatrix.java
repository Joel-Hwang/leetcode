package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.testng.annotations.Test;

public class _1582_SpecialPositionsInaBinaryMatrix {
    public int numSpecial(int[][] mat) {
        int res = 0;
        
        int[] rowSum = new int[mat.length];
        int[] colSum = new int[mat[0].length];

        for(int i = 0; i<mat.length; i++)
            for(int j = 0; j< mat[i].length; j++)
                if(mat[i][j] == 1){
                    rowSum[i]++;
                    colSum[j]++;
                }
        
        for(int i = 0; i<rowSum.length; i++){
            if(rowSum[i] != 1) continue;
            for(int j = 0; j<colSum.length; j++){
                if(colSum[j] != 1) continue;
                if(mat[i][j] == 1) res++;
            }
        }
        
        return res;
    }

    @Test
    public void test(){
        assertEquals(1, numSpecial(new int[][]{{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,1},{0,0,0,0,1,0,0,0},{1,0,0,0,1,0,0,0},{0,0,1,1,0,0,0,0}}));
    }
}
