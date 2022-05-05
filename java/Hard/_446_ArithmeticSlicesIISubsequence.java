package Hard;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _446_ArithmeticSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] nums){
        HashMap<Integer, Integer>[] map = new HashMap[nums.length];
        for(int i = 0; i<map.length; i++) map[i] = new HashMap<>();

        int ans = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<i; j++){
                long cd = (long)nums[i] - (long)nums[j];
                if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) continue;
                int countJ = 0;
                int countI = 0;
                
                if(map[j].containsKey((int)cd)){
                    countJ = map[j].get((int)cd);
                }
                if(map[i].containsKey((int)cd)){
                    countI = map[i].get((int)cd);
                }
                map[i].put((int)cd, countI+countJ+1);
                ans += countJ;
            }
        }

        return ans;
    }

    
    @Test
    public void test(){
        Assert.assertEquals(7, numberOfArithmeticSlices(new int[]{2,4,6,8,10}));
    }
}
