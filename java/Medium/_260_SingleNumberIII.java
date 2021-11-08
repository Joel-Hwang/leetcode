package Medium;

import java.util.HashMap;

public class _260_SingleNumberIII{
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        int i = 0;
        for(int key : map.keySet() ){
            if( map.get(key) == 1) res[i++] = key;    
        }
        return res;
    }
}