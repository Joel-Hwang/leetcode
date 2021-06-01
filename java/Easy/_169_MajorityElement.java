package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

public class _169_MajorityElement{
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> dic = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            dic.put(nums[i], dic.getOrDefault(nums[i], 0)+1);
            if(dic.get(nums[i]) > nums.length/2)
                return nums[i];
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        int major = nums[0], count = 1;
        for(int i = 1; i<nums.length; i++){
            if(count == 0){
                major = nums[i]; 
                count++;
            } else if(nums[i] == major) count++;
            else count--;
        }
        return major;
    }

    @Test
    public void test(){
        assertEquals(majorityElement2(new int[]{10,9,9,9,10}), 9);
        assertEquals(majorityElement(new int[]{3,2,3}), 3);
        assertEquals(majorityElement(new int[]{2,2,1,1,1,2,2}), 2);
    }
}