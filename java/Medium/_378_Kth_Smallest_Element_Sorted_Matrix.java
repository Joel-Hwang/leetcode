package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _378_Kth_Smallest_Element_Sorted_Matrix {
    /*
Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length
n == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= -109
All the rows and columns of matrix are guaranteed to be sorted in non-degreasing order.
1 <= k <= n2 
    */
    
    public _378_Kth_Smallest_Element_Sorted_Matrix(){
      int[][] test = {{1,2},{1,3}};

      System.out.println(kthSmallest(test,2));
        
    }

    public int kthSmallest(int[][] matrix, int k) {
        LinkedList<Integer> lstMatrix = new LinkedList<>();
        for(int i = 0; i<matrix[0].length; i++){
            lstMatrix.add(matrix[0][i]);
        }

        for(int i = 1; i<matrix.length; i++){
            int prevIdx = i-1;
            for(int j = 0; j<matrix[i].length; j++){
                int idx = getIdx(lstMatrix,prevIdx,matrix[i][j]);
                lstMatrix.add(idx,matrix[i][j]);
                prevIdx = idx;
            }
        }
        return lstMatrix.get(k-1);
    }

    private int getIdx(List<Integer> list, int start, int k){
        int l = start;
        int r = list.size();
        while(l<r){
            int mid = (l+r)/2;
            if(mid == l){
                return mid+1;
            }

            if(list.get(mid) > k ){
                r = mid;
            }else{
                l = mid;
            }
        }
        return (l+r)/2;
    }
}
