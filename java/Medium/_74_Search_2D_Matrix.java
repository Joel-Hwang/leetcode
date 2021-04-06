package Medium;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
*/
public class _74_Search_2D_Matrix {
    public _74_Search_2D_Matrix(){
        //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1}};
        System.out.println(searchMatrix(matrix,1));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0; int r = matrix.length*matrix[0].length-1;
        int n = matrix[0].length;
        while(l<=r){
            int mid = (l+r)/2;
            System.out.println(l+", "+matrix[mid/n][mid%n]+", "+r );
            if( matrix[mid/n][mid%n] == target ) return true;
            else if(matrix[mid/n][mid%n] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
}
