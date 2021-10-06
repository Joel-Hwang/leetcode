package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class _442_FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        Set<Integer> key = new HashSet();
        for(int n : nums){
            if(key.contains(n)) res.add(n);
            key.add(n);
        }
        
        return res;
    }


    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int numsI = Math.abs(nums[i]);
            if(nums[numsI-1] < 0) res.add(numsI);
            else nums[numsI-1] = -nums[numsI-1];
        }
        
        return res;
    }

    @Test
    public void test(){
        findDuplicates2(new int[]{4,3,2,7,8,2,3,1});
    }
}
