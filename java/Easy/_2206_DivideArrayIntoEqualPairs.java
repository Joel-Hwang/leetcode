package Easy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class _2206_DivideArrayIntoEqualPairs {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> numberOfFrequency = new HashMap<>();
        for(int num : nums)
            numberOfFrequency.put(num, numberOfFrequency.getOrDefault(num,0)+1);
        for(int num : numberOfFrequency.keySet())
            if(numberOfFrequency.get(num)%2 != 0)
                return false;
        return true;
    }

    public boolean divideArray2(int[] nums) {
        int[] frequemcyOfNumbers = new int[500];
        for(int num : nums)
            frequemcyOfNumbers[num]++;
        for(int frequency : frequemcyOfNumbers)
            if(frequency % 2 != 0)
                return false;
        return true; 
    }
    @Test
    public void test(){
        assertTrue(divideArray(new int[]{3,2,3,2,2,2}));
        assertFalse(divideArray(new int[]{1,2,3,4}));
    }
}
