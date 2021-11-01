package Easy;

import java.util.Arrays;
import java.util.HashMap;

import org.testng.annotations.Test;

public class _496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int curGreat = nums2[nums2.length-1];
        map.put(curGreat, -1);
        for(int i = nums2.length-2; i>=0; i--){
            map.put(nums2[i], getNextG(i, nums2, map));
        }

        for(int i = 0; i<res.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public int getNextG(int i, int[] nums2, HashMap<Integer, Integer> map ){

        if(nums2[i] < nums2[i+1]){
            return nums2[i+1];
        }
        int cur = nums2[i+1];
        while(nums2[i] > cur){
            if(nums2[i] < map.get(cur) ) return map.get(cur);
            cur = map.get(cur);
            if(cur == -1) return -1;
        }
        return -1;
    }

    

    

    @Test
    public void test() {
        System.out.println(Arrays.toString(nextGreaterElement(new int[] { 2,4 }, new int[] { 1, 2, 3, 4 })));
        System.out.println(Arrays.toString(nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
    }
}
