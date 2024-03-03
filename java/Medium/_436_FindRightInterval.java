package Medium;

import java.util.TreeMap;
import java.util.Map.Entry;

import org.testng.annotations.Test;

public class _436_FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Interval> map = new TreeMap<>();
        for(int i = 0; i<intervals.length; i++){
            Interval inv = new Interval();
            inv.start = intervals[i][0];
            inv.end = intervals[i][1];
            inv.index = i;
            map.put(intervals[i][0], inv);
        }

        int[] res = new int[intervals.length];
        for(int i = 0; i<res.length; i++){
            Entry<Integer,Interval> value = map.ceilingEntry(intervals[i][1]);
            res[i] = value==null?-1:value.getValue().index;
        }
        return res;
    }


    @Test
    public void test(){
        findRightInterval(new int[][]{{3,4},{2,3},{1,2}});
    }
}


class Interval{
    int start,end,index;
}
