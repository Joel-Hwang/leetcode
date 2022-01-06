package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.testng.annotations.Test;

public class _1094_CarPooling {
    public boolean carPooling2(int[][] trips, int capacity) {
        HashMap<Integer,Integer> hopOn = new HashMap<>();
        HashMap<Integer,Integer> hopOff = new HashMap<>();
        ArrayList<Integer> stops = new ArrayList<>();

        for(int[] trip : trips){
            if(!hopOn.containsKey(trip[1]) && !hopOff.containsKey(trip[1]))
                stops.add(trip[1]);
            if(!hopOn.containsKey(trip[2]) && !hopOff.containsKey(trip[2]))
                stops.add(trip[2]);

            hopOn.put(trip[1], hopOn.getOrDefault(trip[1], 0 ) + trip[0]);
            hopOff.put(trip[2], hopOff.getOrDefault(trip[2], 0 ) + trip[0]);
        }

        Collections.sort(stops);
        int curNum = 0;
        for(int stop : stops){
            curNum -= hopOff.getOrDefault(stop,0);
            curNum += hopOn.getOrDefault(stop,0);
            if(curNum > capacity) return false;
        }
        return true;
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] stopNumber = new int[1001];
        for(int[] trip : trips){
            stopNumber[trip[2]] -= trip[0];
            stopNumber[trip[1]] += trip[0];
        }

        int curNum = 0;
        for(int i = 0; i<=1000; i++){
            curNum += stopNumber[i];
            if(curNum > capacity) return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(carPooling(new int[][]{{9,0,1},{3,3,7}}, 4));
        System.out.println(carPooling(new int[][]{{2,1,5},{3,3,7}}, 4));
        System.out.println(carPooling(new int[][]{{2,1,5},{3,3,7}}, 5));
    }
}
