package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class _368_LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] currentSubsetSize = new int[nums.length];
        int[] prevElementIndex = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            currentSubsetSize[i] = 1;
            prevElementIndex[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && currentSubsetSize[j] >= currentSubsetSize[i]) {
                    currentSubsetSize[i] = currentSubsetSize[j] + 1;
                    prevElementIndex[i] = j;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int index = getLargestSubsetIndex(currentSubsetSize);
        while(index != -1){
            result.add(nums[index]);
            index = prevElementIndex[index];
        }
        return result;
    }

    private int getLargestSubsetIndex(int[] currentSubsetSize) {
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < currentSubsetSize.length; i++) {
            if (maxValue < currentSubsetSize[i]) {
                maxIndex = i;
                maxValue = currentSubsetSize[i];
            }
        }
        return maxIndex;
    }

    @Test
    public void test(){
        System.out.println(largestDivisibleSubset(new int[]{1,2,3}));
    }
}
