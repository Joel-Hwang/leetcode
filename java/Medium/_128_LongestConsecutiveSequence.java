package Medium;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int n : nums) set.add(n); 

        int res = 0;
        for(int key : set){
            int cur = 0;
            if(!set.contains(key-1)){
                while(set.contains(key+(++cur))){}
            }
            res = Math.max(res,cur);
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
