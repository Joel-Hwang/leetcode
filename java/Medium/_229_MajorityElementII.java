package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class _229_MajorityElementII{
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);    
        }

        for(int key : map.keySet()){
            if(map.get(key) > nums.length/3){
                res.add(key);
            }
        }
        return res;
    }
}