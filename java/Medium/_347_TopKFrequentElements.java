package Medium;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class _347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }


        ArrayList<Map<Integer,Integer>> ar = new ArrayList<Map<Integer,Integer>>();
        for(int key : map.keySet()){
            Map<Integer, Integer> row = new HashMap<Integer,Integer>();
            row.put(key, map.get(key));
            ar.add(row);
        }
        
        
        Collections.sort(ar,(Map<Integer, Integer> a,Map<Integer, Integer> b)->{
            return a.get(a.keySet().iterator().next()) - b.get(b.keySet().iterator().next());
        });
        
        int[] res = new int[k];
        for(int i = 0; i<res.length; i++){
            res[i] = ar.get(ar.size()-1-i).keySet().iterator().next();
        }
        return res;
    }
    @Test
    public void test(){
        assertArrayEquals(new int[]{1,2}, topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        assertArrayEquals(new int[]{1}, topKFrequent(new int[]{1}, 1));
    }
}
