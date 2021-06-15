package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _665_NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        /*
        i까지 왔을 때 i를 빼면 오름차순인가? i-1과 i+1 추가비교 필요
        i를 i-1로 수정하고 cnt+1
        i-1을 빼야 오름차순인가?" i-2와 i 추가비교 필요
        i-1을 i로 수정하고 cnt+1
        이 판단결과가 중요할거 같은데
        둘 다 오름차순 아니면 false
        
        */
        for(int i = 1; i<nums.length; i++){
            if(i<1) continue;
            if(nums[i] <nums[i-1]){
                nums[i-1] = nums[i];
                cnt++;
                i-=2;
            }
        }
        return cnt<2;
    }
    @Test
    public void test(){
        assertTrue(checkPossibility(new int[]{4,2,3}));
        assertFalse(checkPossibility(new int[]{4,2,1}));
        assertFalse(checkPossibility(new int[]{3,4,2,3}));
        assertFalse(checkPossibility(new int[]{5,7,1,8}));
    }
}
