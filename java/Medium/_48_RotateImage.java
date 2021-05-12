package Medium;

import java.util.Arrays;

/*
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
*/
public class _48_RotateImage {

    public _48_RotateImage() {
        //int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        //int[][] matrix = new int[][] { { 5,1,9,11 }, { 2,4,8,10 }, { 13,3,6,7 },{15,14,12,16} };
        int[][] matrix = new int[][] { { 1,2,3,4,5 }, { 6,7,8,9,10 }, { 13,3,6,7 },{15,14,12,16} };
        for (int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));

        rotate(matrix);
        System.out.println();
        for (int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 가운데부터 끝까지 3x3이면 2번, 4x4도 2번
        for (int i = 0; i < Math.ceil(n / 2.0); i++) {
            // 한겹을 swap. n이 4면 맽 곁겹은 3번 loop, 그 다음겹은 1번 loop
            int curLen = n - 1 - (i * 2); // index: 3 1  or 2 0
            // n이 3이면 맽 곁은 2번 loop, 그 다음은 0번 loop(가운데값이라서)
            for (int j = 0; j < curLen; j++) {
                // 배열 첫줄 순회 (0,0~3)
                int temp = matrix[i][j + i];
                matrix[i][j + i] = matrix[curLen - j+i][i];
                // 배열 첫열을 역순 순회(3~0,0)
                matrix[curLen - j+i][i] = matrix[curLen+i][curLen - j+i];
                // 배열 막행을 역순 순회(3~0,0)
                matrix[curLen+i][curLen - j+i] = matrix[j+i][curLen+i];
                // 배열 막열을 순회(n,0~3)
                matrix[j+i][curLen+i] = temp;
            }
        }
    }

}
