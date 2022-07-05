package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class _1610_MaximumNumberOfVisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int res = 0;
        int self = 0;
        List<Double> angles = new ArrayList<>();
        for(int i = 0; i<points.size(); i++){
            List<Integer> point = points.get(i);
            double alpha = getAngle(location, point);
            if(alpha == 361){
                self++;
                continue;
            }
            angles.add(alpha);
        }

        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        for(double d : angles) tmp.add(d + 360);
        res = self;
        for(int i = 0, j = 0; i<tmp.size(); i++){
            int cur = 0;
            while( tmp.get(i) - tmp.get(j) > angle ){
                j++;
            }
            cur = i-j+1 + self;
            res = Math.max(res,cur);
        }
        return res;
    }

    private double getAngle(List<Integer> loc1, List<Integer> loc2){
        int x1 = loc1.get(0);
        int y1 = loc1.get(1);
        int x2 = loc2.get(0);
        int y2 = loc2.get(1);
        return getAngle(x1,y1,x2,y2);
    }

    private double getAngle(int x1, int y1, int x2, int y2){
        float dx = x2-x1;
        float dy = y2-y1;
        if(dx == 0 && dy == 0) return 361;
        return Math.atan2(dy,dx)*(180/Math.PI);
    }

    public int visiblePoints2(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { // edge case of same point
                count++;
                continue;
            } 
            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        for (double d : angles) tmp.add(d + 360); // concatenate to handle edge case
        int res = count;
        for (int i = 0, j = 0; i < tmp.size(); i++) {
            while (tmp.get(i) - tmp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + i - j + 1);
        }
        return res;
    }

    

    private List<List<Integer>> getFromArray2(int[][] ar){
        List<List<Integer>> res = new ArrayList<>();
        for(int[] row : ar){
            List<Integer> tempRow = new ArrayList<>();
            for(int col : row){
                tempRow.add(col);
            }
            res.add(tempRow);
        }
        return res;
    }
    private List<Integer> getFromArray(int[] ar){
        List<Integer> res = new ArrayList<>();
        for(int col : ar)
            res.add(col);
        return res;
    }
    @Test
    public void test(){
        int[][] points = null;
        int[] loc = null;
        int angle = 0;

        points = new int[][]{{0,0},{0,2}};
        loc = new int[]{1,1};
        angle = 90;
        assertEquals(2,visiblePoints2(getFromArray2(points), angle, getFromArray(loc)));



        points = new int[][]{
            {41,7},{22,94},{90,53},{94,54},{58,50},{51,96},{87,88},{55,98},{65,62},
            {36,47},{91,61},{15,41},{31,94},{82,80},{42,73},{79,6},{45,4}};
        loc = new int[]{6,84};
        angle = 17;
        assertEquals(5,visiblePoints(getFromArray2(points), angle, getFromArray(loc)));


        points = new int[][]{{1,0},{2,1}};
        loc = new int[]{1,1};
        angle = 13;
        assertEquals(1,visiblePoints(getFromArray2(points), angle, getFromArray(loc)));

        points = new int[][]{{1,1},{2,2},{1,2},{2,1}};
        loc = new int[]{1,1};
        angle = 0;
        assertEquals(2,visiblePoints(getFromArray2(points), angle, getFromArray(loc)));

        points = new int[][]{{2,1},{2,2},{3,3}};
        loc = new int[]{1,1};
        angle = 90;
        assertEquals(3,visiblePoints(getFromArray2(points), angle, getFromArray(loc)));
        
        points = new int[][]{{2,1},{2,2},{3,4},{1,1}};
        loc = new int[]{1,1};
        angle = 90;
        assertEquals(4,visiblePoints(getFromArray2(points), angle, getFromArray(loc)));


    }
}
