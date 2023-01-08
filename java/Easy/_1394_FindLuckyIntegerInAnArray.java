package Easy;
import java.util.*;
public class _1394_FindLuckyIntegerInAnArray {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = arr.length-1; i >= 0; i--)
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        int res = -1;
        for(int key : map.keySet()){
            if(key != map.get(key)) continue;
            res = Math.max(res,key);
        }
        return res;
    }


    public int findLucky2(int[] arr) {
        int[] nums = new int[501];
        for(int a : arr) nums[a]++;
        for(int i = 500;i>0;i--)
			if(nums[i]==i) return i;
        return -1;
    }
}
