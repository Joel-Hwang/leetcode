package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class _447_NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for(int i = 0; i<points.length; i++) {
            Map<Integer, Integer> distanceMap = new HashMap<>();
            for(int j = 0; j<points.length; j++) {
                int distance = getDistance(points[i] , points[j]);
                distanceMap.put(distance, distanceMap.getOrDefault(distance, 0)+1);
            }
            
            for(int key : distanceMap.keySet()) {
                if(distanceMap.get(key)>1){
                    res += getCases(distanceMap.get(key));
                }
            }
        }
        return res;
    }

    private int getDistance(int[] a, int[] b){
        int disX = a[0]-b[0];
        int disY = a[1]-b[1];
        return disX*disX + disY*disY;
        //return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    private int getCases(int n){
        //nP2
        return n*(n-1);
    }
    @Test
    public void test(){
        assertEquals(20, numberOfBoomerangs(new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}}));
        assertEquals(2, numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}}));
    }
}
