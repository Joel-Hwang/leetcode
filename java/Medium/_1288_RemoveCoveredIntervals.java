package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _1288_RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        int res = intervals.length;
        for(int i = 1; i<intervals.length; i++){
            if(isIn(intervals[i-1], intervals[i]))
                res--;
        }

        return res;
    }

    private boolean isIn(int[] o1, int[] o2){
        boolean isIn = o1[0] <= o2[0] && o2[1] <= o1[1];
        if(isIn){
            o2[0] = o1[0];
            o2[1] = o1[1];
        }
        return isIn;
    }


    @Test
    public void test(){
        System.out.println(removeCoveredIntervals(new int[][]{{1,4},{2,3}}));
        System.out.println(removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}}));
    }
}
