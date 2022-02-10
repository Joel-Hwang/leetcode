package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _532_KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        int res = 0;
        
        for(int n : map.keySet()){
            if(k !=0 &&map.containsKey(n+k)){
                res++;
            }
            if(k ==0 &&map.get(n)>1){
                res++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(findPairs(new int[]{3,1,4,1,5}, 2));
        System.out.println(findPairs(new int[]{1,2,3,4,5}, 1));
        System.out.println(findPairs(new int[]{1,3,1,5,4}, 0));
    }


}
