package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _2248_IntersectionOfMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> frequencies = new TreeMap<>();
        for(int[] row : nums){
            for(int column : row){
                frequencies.put(column, frequencies.getOrDefault(column, 0)+1);
            }
        }

        for(int key : frequencies.keySet()){
            if(frequencies.get(key) == nums.length) result.add(key);
        }
        return result;
    }
}
