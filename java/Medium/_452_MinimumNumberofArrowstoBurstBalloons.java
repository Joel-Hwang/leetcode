package Medium;

import java.util.Arrays;
import java.util.Comparator;
import org.testng.annotations.Test;

public class _452_MinimumNumberofArrowstoBurstBalloons{
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if( o1[0] > o2[0] ) return 1;
                if( o1[0] == o2[0] ) return 0;
                if( o1[0] < o2[0] ) return -1;
                return o1[0]-o2[0];
            };
        });

        int result = 0;
        for(int i = 0; i<points.length; i++){
            int tempResult = getCount(points, i);
            i += tempResult-1;
            result++;
        }


        return result;
    }

    private int getCount(int[][] points, int startIndex){
        int arrow = points[startIndex][1];
        int result = 0;
        for(int i = startIndex; i < points.length; i++){
            if( points[i][0] <= arrow){
                result++;
                arrow = Math.min(arrow, points[i][1]);
            }else{
                break;
            }
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
        System.out.println(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }
}