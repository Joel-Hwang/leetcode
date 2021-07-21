package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class RemoveIslands {
    //0 is water. 1 is part of island.
    //remove every island except for connected on the border.
    public int[][] removed(int[][] matrix) {

        // copy border value and fill 0s inside
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++)
            res[0][j] = matrix[0][j];

        for (int j = 0; j < matrix[0].length; j++) 
            res[matrix.length-1][j] = matrix[matrix.length-1][j];

        for (int i = 0; i < matrix.length; i++) 
            res[i][0] = matrix[i][0];
        
        for (int i = 0; i < matrix.length; i++) 
            res[i][matrix[0].length-1] = matrix[i][matrix[0].length-1];

        for (int i = 0; i < matrix.length; i++) {
            // I will touch all elems in first and last row
            if (i == 0 || i == matrix.length - 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 1) {
                        // check
                        checkFromBorder(i - 1, j, matrix, res);
                        checkFromBorder(i + 1, j, matrix, res);
                        checkFromBorder(i, j - 1, matrix, res);
                        checkFromBorder(i, j + 1, matrix, res);
                    }
                }
            } else {
                // Touch first and end elems except for first and last row
                for (int j = 0; j < matrix[0].length; j+=matrix.length-1) {
                    if (matrix[i][j] == 1) {
                        checkFromBorder(i - 1, j, matrix, res);
                        checkFromBorder(i + 1, j, matrix, res);
                        checkFromBorder(i, j - 1, matrix, res);
                        checkFromBorder(i, j + 1, matrix, res);
                    }
                }
            }
        }
        return res;
    }

    private void checkFromBorder(int i, int j, int[][] matrix, int[][] res) {
        // check i, j are in the array.
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return;
        // return if it is not part of island.
        if (matrix[i][j] == 0 || res[i][j] == 1)
            return;

        res[i][j] = 1;
        checkFromBorder(i - 1, j, matrix, res);
        checkFromBorder(i + 1, j, matrix, res);
        checkFromBorder(i, j - 1, matrix, res);
        checkFromBorder(i, j + 1, matrix, res);
    }

    @Test
    public void test() {
        int[][] map = { 
            { 0, 0, 0, 1, 0, 0 }, 
            { 0, 1, 0, 1, 0, 0 }, 
            { 0, 1, 0, 1, 0, 0 }, 
            { 0, 0, 0, 1, 0, 0 }, 
        };

        map = new int[][]{ 
            { 0, 0, 0, 1, 0, 0 }, 
            { 1, 1, 0, 1, 1, 0 }, 
            { 0, 1, 0, 0, 1, 1 }, 
            { 0, 0, 1, 1, 0, 0 }, 
            { 1, 0, 0, 0, 0, 0 }, 
        };
        System.out.println("input");
        for (int[] row : map) {
            System.out.println(Arrays.toString(row));
        }
        
        map = removed(map);
        System.out.println("output");
        for (int[] row : map) {
            System.out.println(Arrays.toString(row));
        }
    }
}
