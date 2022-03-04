package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _799_ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[query_row+1][query_row+1];
        glasses[0][0] = poured;
        for(int i = 0; i<=query_row && i<query_row; i++){
            for(int j = 0; j<=i; j++){
                double nextPoured = (glasses[i][j]-1.0)/2.0;
                if(nextPoured > 0){
                    glasses[i+1][j] += nextPoured;
                    glasses[i+1][j+1] += nextPoured;
                }
            }
        }   
        return Math.min(1.0, glasses[query_row][query_glass]);
    }

    @Test
    public void test(){
        assertEquals(0.0,champagneTower(1, 1, 1));
        assertEquals(0.5,champagneTower(2, 1, 1));
        assertEquals(1.0,champagneTower(100000009, 33, 17));
    }
}
