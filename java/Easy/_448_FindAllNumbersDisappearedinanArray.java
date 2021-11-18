package Easy;

import java.util.ArrayList;
import java.util.List;

public class _448_FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            map[nums[i]-1]++;
        }

        for(int i = 0; i<map.length; i++){
            if(map[i] == 0) res.add(i+1);
        }
        return res;
        
    }
}
