import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ThreeSum {
    public ThreeSum(){
        List<List<Integer>> result = threeSum2(new int[]{-2,0,1,1,2});
        //List<List<Integer>> result = threeSum(new int[]{0,0,0,0});
        for(List<Integer> row : result){
            for(Integer i : row){
                System.out.print(i +", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            int l=i+1, r=nums.length-1;
            if(i>0 && nums[i] == nums[i-1]) continue;
            while(l<r){
                int sum = nums[i];
                if(nums[l] + nums[r] + sum == 0){
                    result.add(Arrays.asList(nums[l], nums[r], sum));
                    while(l<r&&nums[l] == nums[l+1]) l++;
                    while(l<r&&nums[r] == nums[r-1]) r--;
                    l++;r--;
                }else if( nums[l] + nums[r] + sum < 0 ){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
    }
}
