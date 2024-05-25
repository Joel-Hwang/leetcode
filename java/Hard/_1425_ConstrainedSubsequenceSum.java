package Hard;

import org.testng.annotations.Test;
import java.util.*;
public class _1425_ConstrainedSubsequenceSum {

    public int constrainedSubsetSum(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int result = nums[0];
        for(int i = 0; i<nums.length; i++){
            int max = nums[i];
            int sum = nums[i] +  (treeMap.size()==0?0:treeMap.lastKey());
            max = Math.max(max,sum);
           
            nums[i] = max;
            treeMap.put(nums[i],treeMap.getOrDefault(nums[i], 0)+1);
            if(i>=k){
                treeMap.put(nums[i-k], treeMap.get(nums[i-k])-1);
                if(treeMap.get(nums[i-k]) == 0)
                    treeMap.remove(nums[i-k]);
            }
            
            result = Math.max(result,max);
        }

        return result;
    }


    public int constrainedSubsetSum2(int[] nums, int k) {
        int result = nums[0];
        for(int i = 0; i<nums.length; i++){
            int max = nums[i];
            for(int j = 1; j<=k && i-j>=0; j++){
                int sum = nums[i] + nums[i-j];
                max = Math.max(max,sum);
            }
            nums[i] = max;
            result = Math.max(result,max);
        }

        return result;
    }

    @Test
    public void test(){
        System.out.println(constrainedSubsetSum(new int[]{10,10,10,10,-10,-1,-10,-1,-10,10,10,10,10}, 3));
        System.out.println(constrainedSubsetSum(new int[]{1,-5000,-5000,5000}, 2));
        System.out.println(constrainedSubsetSum(new int[]{10,2,-10,5,20}, 2));
        System.out.println(constrainedSubsetSum(new int[]{-1,-2,-3}, 1));
        System.out.println(constrainedSubsetSum(new int[]{10,-2,-10,-5,20}, 2));
    }
}
