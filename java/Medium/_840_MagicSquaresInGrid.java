package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _840_MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[i].length; j++){
                if(isMagicSquare(grid, j, i)) res++;
            }
        }

        return res;
    }


    private boolean isMagicSquare(int[][] grid, int startX, int startY){
        if ( startX+2 >= grid[0].length || startY+2 >= grid.length ) return false;
        
        int sumOfRow1 = grid[startY][startX] + grid[startY][startX+1] + grid[startY][startX+2];
        int sumOfRow2 = grid[startY+1][startX] + grid[startY+1][startX+1] + grid[startY+1][startX+2];
        int sumOfRow3 = grid[startY+2][startX] + grid[startY+2][startX+1] + grid[startY+2][startX+2];

        int sumOfCol1 = grid[startY][startX]   + grid[startY+1][startX]   + grid[startY+2][startX]  ;
        int sumOfCol2 = grid[startY][startX+1] + grid[startY+1][startX+1] + grid[startY+2][startX+1];
        int sumOfCol3 = grid[startY][startX+2] + grid[startY+1][startX+2] + grid[startY+2][startX+2];

        int sumOfLeftRight = grid[startY][startX]   + grid[startY+1][startX+1] + grid[startY+2][startX+2];
        int sumOfRightLeft = grid[startY][startX+2] + grid[startY+1][startX+1] + grid[startY+2][startX]  ;

        boolean areSame =  sumOfRow1 == sumOfRow2 && sumOfRow2 == sumOfRow3 && sumOfRow3 == sumOfCol1 && 
        sumOfCol1 == sumOfCol2 && sumOfCol2 == sumOfCol3 && sumOfCol3 == sumOfLeftRight && 
        sumOfLeftRight == sumOfRightLeft;

        if(!areSame) return false;
        
        int[] nines = new int[10];
        for(int i = 0; i< 3; i++){
            for(int j = 0; j<3; j++){
                int gridVal = grid[startY+i][startX+j];
                if(gridVal >9) return false;
                nines[  gridVal  ]++;
            }
        }

        for(int i = 1; i<nines.length; i++){
            if(nines[i] == 0) return false;
        }
        return true;
    }

    @Test
    public void test(){
        assertEquals(0, numMagicSquaresInside(new int[][]{{5,5,5},{5,5,5},{5,5,5}}));
        assertEquals(1, numMagicSquaresInside(new int[][]{{4,3,8,4},{9,5,1,9},{2,7,6,2}}));
    }
}
