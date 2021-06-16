package Medium;

import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

public class _54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        
        int i=0,j=0;
        int arrow = 0;
        while(res.size()<matrix.length*matrix[0].length){
            res.add(matrix[i][j]);
            matrix[i][j] = 101;
            switch(arrow%4){
                case 0: //left
                    if(j == matrix[0].length-1 || matrix[i][j+1] == 101){
                        arrow++; 
                        i++;
                    } else j++;
                break;
                case 1: //bottom
                    if(i == matrix.length-1 || matrix[i+1][j] == 101){
                        arrow++;
                        j--;
                    } else i++;
                break;
                case 2: //right
                    if(j == 0 || matrix[i][j-1] == 101){
                        arrow++;
                        i--;
                    }else j--;
                break;
                case 3: //top
                    if(i == 0 || matrix[i-1][j] == 101){
                        arrow++;
                        j++;
                    }else i--;
                break;
            }
        }

        return res;
    }

    @Test
    public void test(){
        List<Integer> r1 = spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        for(Integer r : r1) System.out.print(r + " ");
        System.out.println();
    }
}
