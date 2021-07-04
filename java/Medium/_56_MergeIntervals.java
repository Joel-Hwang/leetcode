package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        /*Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });*/
        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[0], i2[0]));

        int[][] res = new int[intervals.length][intervals[0].length];

        int cur = 0;
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];

        for(int i=1; i<res.length; i++){
            if(res[cur][1] >= intervals[i][0]){
                res[cur][1] = Math.max(res[cur][1], intervals[i][1]);
            }else{
                cur++;
                res[cur][0] = intervals[i][0];
                res[cur][1] = intervals[i][1];
            }
        }

        return Arrays.copyOfRange(res, 0, cur+1);
    }

    @Test
    public void test(){
        
        for(int[] i : merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})) System.out.println(Arrays.toString(i));
        System.out.println();

        for(int[] i : merge(new int[][]{{1,4},{4,5}})) System.out.println(Arrays.toString(i));
        System.out.println();
        
        for(int[] i : merge(new int[][]{{1,4},{0,4}})) System.out.println(Arrays.toString(i));
        System.out.println();

        for(int[] i : merge(new int[][]{{1,4},{0,0}})) System.out.println(Arrays.toString(i));
        System.out.println();


    }
}
