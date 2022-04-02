package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _240_Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0; 
        int col = matrix[0].length-1;
        while(row < matrix.length && col>=0 ){
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] < target)
                row++;
            else col--;
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        for(int i = 0; i<matrix.length; i++){
            if(target < matrix[i][0]) break;
            if(target > matrix[i][matrix[i].length-1]) continue;
            if(binarySearch(matrix, target, i, -1)) return true;
        }
        for(int i = 0; i<matrix[0].length; i++){
            if(target < matrix[0][i]) break;
            if(target > matrix[matrix.length-1][i]) continue;
            if(binarySearch(matrix, target, -1, i)) return true;
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int row, int col){
        int l = 0, r = row>=0?matrix[row].length-1:matrix.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if((row>=0 && target == matrix[row][mid]) || 
               (col>=0 && target == matrix[mid][col]) ){
                return true;
            }
            if( (row>=0 && target < matrix[row][mid]) ||
                (col >=0 && target < matrix[mid][col]) ){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }

    @Test
    public void test(){
        assertEquals(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5), true);
        
        assertEquals(searchMatrix(new int[][]{{1,1}}, 2), false);

    }
}
