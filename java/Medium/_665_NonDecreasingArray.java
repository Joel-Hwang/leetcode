package Medium;

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
            if(nums[i] >=nums[i-1]) continue;
            int next = i==nums.length-1?Math.max(nums[i],nums[i-1]):nums[i+1];
            int cur = Math.max(next, nums[i-1]);

            if(nums[i-1]<=cur && cur<=next){
                cnt++;
                continue;
            }
            int prev = Math.max(nums[i], nums[i<2?i:i-2]);
            if(nums[i<2?i:i-2]<=prev && prev<=nums[i]){
                cnt++;
                continue;
            }
            return false;
        }
        return cnt<2;
    }

    public boolean checkPossibility2(int[] nums) {
        int cnt = 0;    //the number of changes
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];  //modify nums[i-1] of a priority
                else nums[i] = nums[i-1];   //have to modify nums[i]
            }
        }
        return cnt<=1; 
    }

    @Test
    public void test(){
        assertTrue(checkPossibility(new int[]{4,2,3}));
        assertFalse(checkPossibility(new int[]{4,2,1}));
        assertFalse(checkPossibility(new int[]{3,4,2,3}));
        assertTrue(checkPossibility(new int[]{5,7,1,8}));
        assertTrue(checkPossibility(new int[]{1,2,4,5,3}));
    }
}
