package Medium;

import org.testng.annotations.Test;

public class _915_PartitionArrayintoDisjointIntervalsd {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        for(int i = 0; i<nums.length-1; i++){
            leftMax = Math.max(nums[i], leftMax);
            boolean flag = false;
            for(int j = i+1; j<nums.length; j++){
                if(leftMax <= nums[j]){
                    flag = true;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag) return i+1;
        }
        return 1;
    }

    @Test
    public void test(){
        System.out.println(partitionDisjoint(new int[]{90,47,69,10,43,92,31,73,61,97}));
        System.out.println(partitionDisjoint(new int[]{2,2,0,1,2,3}));
        System.out.println(partitionDisjoint(new int[]{5,0,3,8,6}));
        System.out.println(partitionDisjoint(new int[]{1,1,1,0,6,12}));
        System.out.println(partitionDisjoint(new int[]{1,1}));
        System.out.println(partitionDisjoint(new int[]{0,0,0,0,0,1}));
        System.out.println(partitionDisjoint(new int[]{2,2,0,1,0,3}));
    }
}
