package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _75_SortColors {
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for(int i = 0; i<nums.length; i++){
           cnt[nums[i]]++;
        }

        for(int i = 0; i<cnt[0]; i++){
            nums[i] = 0;
        }
        for(int i = cnt[0]; i<cnt[0]+cnt[1]; i++){
            nums[i] = 1;
        }
        for(int i = cnt[0]+cnt[1]; i<cnt[0]+cnt[1]+cnt[2]; i++){
            nums[i] = 2;
        }
    }

    private void bubble(int[] nums){
        for(int i = 0; i<nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    @Test
    public void test(){
        int[] a = {2,0,2,1,1,0};
        sortColors(a);
        System.out.println(Arrays.toString(a));
        int[] a1 = {2,0,2,1,1,0};
        bubble(a1);
        System.out.println(Arrays.toString(a));
    }
}
