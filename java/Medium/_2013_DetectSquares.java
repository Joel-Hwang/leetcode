package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class _2013_DetectSquares {
    class DetectSquares {
        Map<Integer, List<int[]>> xPoints;
        Map<Integer, Integer> points;
        public DetectSquares() {
            xPoints = new HashMap<>();
            points = new HashMap<>();
        }
        
        public void add(int[] point) {
            int key = point[0]*10000+point[1];
            points.put(key, points.getOrDefault(key, 0)+1);
            
            List<int[]> xPointList = xPoints.getOrDefault(point[0], new ArrayList<>());
            xPointList.add(point);
            xPoints.putIfAbsent(point[0], xPointList);
        }
        
        public int count(int[] point) {
            int result = 0;
            List<int[]> xSames = xPoints.getOrDefault(point[0], new ArrayList<>());
            for(int[] xSame : xSames){
                if(point[1] == xSame[1]) continue;
                int length = Math.abs(point[1]-xSame[1]);
                int x1 = point[0]+length;
                int x2 = point[0]-length;
                int x1Count = points.getOrDefault(x1*10000+point[1], 0);
                int x2Count = points.getOrDefault(x2*10000+point[1], 0);
                if(x1Count>0) result += x1Count*points.getOrDefault(x1*10000+xSame[1], 0);
                if(x2Count>0) result += x2Count*points.getOrDefault(x2*10000+xSame[1], 0);
                
            }
            return result;
        }
    }

    @Test
    public void test(){
        DetectSquares ds = new DetectSquares();

        ds.add(new int[]{5,10});
        ds.add(new int[]{10,5});
        ds.add(new int[]{10,10});
        ds.add(new int[]{3,0});
        ds.add(new int[]{8,0});
        ds.add(new int[]{8,5});
        ds.add(new int[]{9,0});
        ds.add(new int[]{9,8});
        ds.add(new int[]{1,8});
        ds.add(new int[]{0,0});
        ds.add(new int[]{8,0});
        ds.add(new int[]{8,8});
        System.out.println(ds.count(new int[]{0,8}));
    }
}

