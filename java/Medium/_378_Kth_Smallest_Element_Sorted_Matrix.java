package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _378_Kth_Smallest_Element_Sorted_Matrix {
    /*
     * Given an n x n matrix where each of the rows and columns are sorted in
     * ascending order, return the kth smallest element in the matrix.
     * 
     * Note that it is the kth smallest element in the sorted order, not the kth
     * distinct element.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8 Output: 13
     * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and
     * the 8th smallest number is 13 Example 2:
     * 
     * Input: matrix = [[-5]], k = 1 Output: -5
     * 
     * 
     * Constraints:
     * 
     * n == matrix.length n == matrix[i].length 1 <= n <= 300 -109 <= matrix[i][j]
     * <= -109 All the rows and columns of matrix are guaranteed to be sorted in
     * non-degreasing order. 1 <= k <= n2
     */

    /*
     * Since each row and column of the matrix is sorted, is it possible to use
     * Binary Search to find the Kth smallest number?
     * 
     * The biggest problem to use Binary Search in this case is that we don’t have a
     * straightforward sorted array, instead we have a matrix. As we remember, in
     * Binary Search, we calculate the middle index of the search space (‘1’ to ‘N’)
     * and see if our required number is pointed out by the middle index; if not we
     * either search in the lower half or the upper half. In a sorted matrix, we
     * can’t really find a middle. Even if we do consider some index as middle, it
     * is not straightforward to find the search space containing numbers bigger or
     * smaller than the number pointed out by the middle index.
     * 
     * An alternate could be to apply the Binary Search on the “number range”
     * instead of the “index range”. As we know that the smallest number of our
     * matrix is at the top left corner and the biggest number is at the bottom
     * lower corner. These two number can represent the “range” i.e., the start and
     * the end for the Binary Search. Here is how our algorithm will work:
     * 
     * Start the Binary Search with start = matrix[0][0] and end = matrix[n-1][n-1].
     * Find middle of the start and the end. This middle number is NOT necessarily
     * an element in the matrix. Count all the numbers smaller than or equal to
     * middle in the matrix. As the matrix is sorted, we can do this in O(N). While
     * counting, we can keep track of the “smallest number greater than the middle”
     * (let’s call it n1) and at the same time the “biggest number less than or
     * equal to the middle” (let’s call it n2). These two numbers will be used to
     * adjust the "number range" for the Binary Search in the next iteration. If the
     * count is equal to ‘K’, n1 will be our required number as it is the “biggest
     * number less than or equal to the middle”, and is definitely present in the
     * matrix. If the count is less than ‘K’, we can update start = n2 to search in
     * the higher part of the matrix and if the count is greater than ‘K’, we can
     * update end = n1 to search in the lower part of the matrix in the next
     * iteration. Here is the visual representation of this algorithm:
     */

    public _378_Kth_Smallest_Element_Sorted_Matrix() {
        // 13
        System.out.println(kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8));
        // 2
        System.out.println(kthSmallest(new int[][] { { 1, 2 }, { 1, 3 } }, 3));
        // -5
        System.out.println(kthSmallest(new int[][] { { -5 } }, 1));
        System.out.println(kthSmallest(new int[][] { { 1, 5, 8 }, { 10, 12, 13 }, { 15, 17, 19 } }, 9));

    }

    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix.length - 1];
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cnt = getLowerCnt(matrix, mid, k);
            if (cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid-1;
            }
        }
        return lo;
    }

    private int getLowerCnt(int[][] matrix, int pMid, int k) {
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            if (row[0] > pMid)
                break;
            for(int j = 0; j<row.length; j++){
                if(row[j]<=pMid){
                    cnt++;
                }else{
                    break;
                }
            }
        }
        return cnt;
    }

    // mid는 중간값이고 이게 matrix 안에 있을 필요는 없다.
    public int kthSmallest2(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1];// [lo, hi)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2; // => (lo+hi)/2
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid)
                    j--;
                count += (j + 1);
            }
            if (count < k)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }




    public class Solution2 {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int count = getLessEqual(matrix, mid);
                if (count < k) lo = mid + 1;
                else hi = mid - 1;
                // when "count > k", the binary search continues until "count == k"
              // also it's obvious there must be a "mid" value for which "count == k"
              // when "count == k", the "mid" value is larger than or equal to the k-th smallest number in the matrix
              // and binary search continues until "lo == hi", thus guarantee that the "mid" value is qual to the k-th smallest number
            }
            return lo;
        }
        
        private int getLessEqual(int[][] matrix, int val) {
            int res = 0;
            int n = matrix.length, i = n - 1, j = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] > val) i--;
                else {
                    res += i + 1;
                    j++;
                }
            }
            return res;
        }
    }
}
