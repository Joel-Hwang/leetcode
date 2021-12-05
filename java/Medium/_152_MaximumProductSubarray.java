package Medium;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        int nCnt = 0;
        int res = nums[0];

        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0){
                map.put(i,nCnt);
                nCnt = 0;
                res = 0;
            }
            else if(nums[i]<0){
                nCnt++;
            }else;
        }
        map.put(nums.length, nCnt);
        nCnt = 0;
        
        
        ArrayList<Integer> keys = new ArrayList();
        for(Integer key : map.keySet()){
            keys.add(key);
        }

        
        res = Math.max(res, getProd(nums,0, keys.get(0)-1,map.get(keys.get(0))%2==0 ));
        int prevKey = keys.get(0);
        for(int i = 1; i<keys.size(); i++){
            res = Math.max(res, getProd(nums,prevKey+1, keys.get(i)-1,map.get(keys.get(i))%2==0 ));
            prevKey = keys.get(i);
        }

        return res;
    }

    private int getProd(int[] nums, int start, int end, boolean isEven){
        if(start > end) return nums[0];
        if(start == end) return nums[start];
        int res = 1;
        if(isEven){
            for(int i = start; i<=end; i++) res *= nums[i];
            return res;
        }

        ArrayList<Integer> nList = new ArrayList<>();
        for(int i = start; i <= end; i++){
            if(nums[i] < 0){
                nList.add(i);
            }
        }

        int tempRes1 = 1, tempRes2 = 1;
        for(int i = nList.get(0)+1; i<=end; i++){
            tempRes1 *= nums[i];
        }

        for(int i = start; i<nList.get(nList.size()-1); i++){
            tempRes2 *= nums[i];
        }
        res = Math.max(tempRes1, tempRes2);

        return res;
    }

    @Test
    public void test(){
        System.out.println(maxProduct(new int[]{-3,-1,3,5,-6,-6,-1,6,-3,-5,1,0,-6,-5,0,-2,6,1,0,5}));
        System.out.println(maxProduct(new int[]{2,0,3,-2}));
        System.out.println(maxProduct(new int[]{-2,0}));
        System.out.println(maxProduct(new int[]{0}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
        System.out.println(maxProduct(new int[]{-2}));
        System.out.println(maxProduct(new int[]{-2,0, -1}));
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
}
