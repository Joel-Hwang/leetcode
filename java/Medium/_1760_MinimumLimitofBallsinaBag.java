package Medium;


import org.testng.annotations.Test;

public class _1760_MinimumLimitofBallsinaBag {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 1_000_000_000;
        while(left < right){
            int mid = (right + left) / 2, count = 0;
            for(int n : nums)
                count += (n-1)/mid;
            if(count > maxOperations){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public int minimumSize2(int[] A, int k) {
        int left = 1, right = 1_000_000_000;
        while (left < right) {
            int mid = (left + right) / 2, count = 0;
            for (int a : A)
                count += (a - 1) / mid;
            if (count > k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    @Test
    public void test(){
        System.out.println(minimumSize(new int[]{1}, 1));
        System.out.println(minimumSize(new int[]{431,922,158,60,192,14,788,146,788,775,772,792,68,143,376,375,877,516,595,82,56,704,160,403,713,504,67,332,26}, 80));
    }
}
