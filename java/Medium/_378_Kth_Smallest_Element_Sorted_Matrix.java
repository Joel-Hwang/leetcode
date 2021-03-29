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
     // int[][] test = {{1,2},{1,3}};
      int[][] test = {{1,3,5},{6,7,12},{11,14,14}};

      //System.out.println(kthSmallest(test,3));
      System.out.println(kthSmallest(test,3));
        
    }

    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length-1][matrix.length-1]+1;
        while(lo<hi){
            int mid = (lo+hi)/2;
            int cnt = getLowerCnt(matrix,mid,k);
            if(cnt>k){
                hi = mid;
            }else{
                lo = mid;
            }
        }
        return lo;        
    }

    private int getLowerCnt(int[][] matrix, int pMid, int k){
        int cnt = 0;
        for(int i = 0; i<matrix.length; i++){
            int[] row = matrix[i];
            if(row[0] > pMid) break;
            int l = 0;
            int r = row.length-1;
            
            while(l<r){
                int mid = (l+r)/2;
                if(l+1 == r){
                    cnt += row[r]<pMid?r+1:l+1;
                    break;
                }
                
                if(row[mid] > pMid){
                    r = mid;
                }else if(row[mid] < pMid){
                    l = mid;
                }else{
                    cnt+=mid;
                    break;
                }
            }
            if(cnt > k) break;
        }
        return cnt;
    }























    public int kthSmallest2(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;  // => (lo+hi)/2
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
