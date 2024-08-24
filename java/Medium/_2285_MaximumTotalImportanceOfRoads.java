package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class _2285_MaximumTotalImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {
        int[] frequencies = new int[n];
        for(int[] road : roads){
            frequencies[road[0]]++;
            frequencies[road[1]]++;
        }
        
        Arrays.sort(frequencies);

        long result = 0;
        for(int i = 0; i<frequencies.length; i++){
            result += 1L*(i+1)*frequencies[i];
        }

        return result;
    }
    public long maximumImportance2(int n, int[][] roads) {
        int[] frequencies = new int[n];
        for(int[] road : roads){
            frequencies[road[0]]++;
            frequencies[road[1]]++;
        }
        int[][] assigned = new int[n][2];
        for(int i = 0; i<frequencies.length; i++){
            assigned[i][0] = i;
            assigned[i][1] = frequencies[i];
        }

        Arrays.sort(assigned, (a, b)->Integer.compare(a[1], b[1]));

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<assigned.length; i++){
            map.put(assigned[i][0], i+1);
        }
        

        long result = 0;
        for(int[] road : roads){
            result += map.get(road[0]) + map.get(road[1]);
        }

        return result;
    }

    @Test
    public void test(){
        System.out.println(maximumImportance(5, new int[][]{{0,3},{2,4},{1,3}}));
        System.out.println(maximumImportance(5, new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
    }
}
