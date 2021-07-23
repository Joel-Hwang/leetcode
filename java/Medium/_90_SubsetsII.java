package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class _90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //for(int cnt = 0; cnt<=nums.length; cnt++){
            comb(nums,0,new ArrayList<>(), res);
        //}
        
        return res;
    }  

    public void comb(int[] nums, int start,List<Integer> prt, List<List<Integer>> res){
        res.add(new ArrayList<>(prt));
        
        for(int i = start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1]) continue;
            prt.add(nums[i]);
            comb(nums,i+1,prt,res);
            prt.remove(prt.size()-1);
        }
        return;

    }

    //Back Tracking
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        subsetsWithDupHelper(subsets, currentSubset, nums, 0);
        return subsets;
    }

    private void subsetsWithDupHelper(List<List<Integer>> subsets, List<Integer> currentSubset, int[] nums, int index) {
        // Add the subset formed so far to the subsets list.
        subsets.add(new ArrayList<>(currentSubset));

        for (int i = index; i < nums.length; i++) {
            // If the current element is a duplicate, ignore.
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            currentSubset.add(nums[i]);
            subsetsWithDupHelper(subsets, currentSubset, nums, i + 1);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    @Test
    public void test(){
        subsetsWithDup(new int[]{1,2,3});
        subsetsWithDup(new int[]{1,2,2});
        subsetsWithDup(new int[]{0});
    }
}
