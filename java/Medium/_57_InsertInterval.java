package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int cur = 0;

        boolean merged = false;
        for(int i = 0; i<intervals.length; i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            int x = newInterval[0];
            int y = newInterval[1];
            //2개의 interval의 공존하는 범위를 3개로 나눔
            //newInterval , interval
            //interval, newInterval
            //mix(newInterval, interval)
            if(s > y){
                if(!merged){
                    res[cur][0] = x;
                    res[cur][1] = y;
                    cur++;
                }
                merged = true;
                res[cur][0] = s;
                res[cur][1] = e;
                cur++;
            }else if(e<x){
                res[cur][0] = s;
                res[cur][1] = e;
                cur++;
            }else{
                newInterval[0] = Math.min(s, x);
                newInterval[1] = Math.max(e, y);
            }
        }

        if(cur == 0 || !merged){
            res[cur][0] = newInterval[0];
            res[cur][1] = newInterval[1];
            cur++;
        }

        return Arrays.copyOfRange(res, 0, cur);
    }


    @Test
    public void test(){
        for(int[] i : insert(new int[][]{{2,5},{6,7},{8,9}},new int[]{0,1})) System.out.println(Arrays.toString(i));
        System.out.println();
        for(int[] i : insert(new int[][]{{1,3},{6,9}},new int[]{2,5})) System.out.println(Arrays.toString(i));
        System.out.println();
        for(int[] i : insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8})) System.out.println(Arrays.toString(i));
        System.out.println();
        for(int[] i : insert(new int[][]{},new int[]{5,7})) System.out.println(Arrays.toString(i));
        System.out.println();
        for(int[] i : insert(new int[][]{{1,5}},new int[]{6,8})) System.out.println(Arrays.toString(i));
        System.out.println();
        for(int[] i : insert(new int[][]{{1,5}},new int[]{0,0})) System.out.println(Arrays.toString(i));
        System.out.println();
        
    }
}