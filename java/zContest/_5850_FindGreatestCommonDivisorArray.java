package zContest;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _5850_FindGreatestCommonDivisorArray {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        
        return gcd(nums[0],nums[nums.length-1]);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
          int temp = a % b;
          a = b;
          b = temp;
        }
        return Math.abs(a);
      }

    @Test
    public void test(){
        System.out.println(findGCD(new int[]{2,5,6,9,10}));
        System.out.println(findGCD(new int[]{7,5,6,8,3}));
    }
}
