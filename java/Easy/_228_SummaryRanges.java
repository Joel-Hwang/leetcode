package Easy;
import java.util.*;

import org.testng.annotations.Test;
public class _228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 0) return res;

        String start = String.valueOf(nums[0]), end = start;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == nums[i-1] +1){
                end = String.valueOf(nums[i]);
            }else{
                res.add( start.equals(end)?start:start+"->"+end);
                start = String.valueOf(nums[i]);
                end = start;
            }
        }
        res.add( start.equals(end)?start:start+"->"+end);
        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(summaryRanges(new int[]{0,2,3,4,6,8,9}).toArray()));
        System.out.println(Arrays.toString(summaryRanges(new int[]{0,1,2,4,5,7}).toArray()));
    }
}
