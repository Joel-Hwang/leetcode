package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _2155_AllDivisionsWithTheHighestScoreOfBinaryArray {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = 0, max = 0;
        for(int num : nums) if(num == 1) r++;
        max = r;
        res.add(0);
        for(int i = 1; i<=nums.length; i++){
            if(nums[i-1] == 0) l++;
            else r--;
            int cur = l+r;
            if(max == cur) res.add(i);
            if(cur > max){
                max = cur;
                res.clear();
                res.add(i);
            }
        } 

        return res;
    }

    @Test
    public void test(){
        maxScoreIndices(new int[]{0,0,1,0});
    }
}
