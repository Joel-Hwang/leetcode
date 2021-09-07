package Medium;

import org.testng.annotations.Test;

public class _396_RotateFunction {
    
    /*
        f0 = 0*A0 + 1*A1 + ... + (n-3)*An-3 + (n-2)*An-2 + (n-1)*An-1
        f1 = 1*A0 + 2*A1 + ... + (n-2)*An-3 + (n-1)*An-2 + 0*An-1
        f2 = 2*A0 + 3*A1 + ... + (n-1)*An-3 + 0*An-2 + 1*An-1

        f1-f0 = A0 + A1 + ... + An-2 - (n-1)*An-1
              = (A0 + ... + An-1) -n*An-1
        f1 = f0 + (A0 + ... + An-1) -n*An-1
        f2 = f1 + (A0 + ... + An-1) -n*An-2
        f2 = f0 + 2*(A0 + ... + An-1) -n*(An-1 + An-2)
    */
    public int maxRotateFunction(int[] nums) {
        int res = 0;
        int sum = 0;
        int f0 = 0;
        int n = nums.length;
        for(int i = 0; i<n; i++){
            sum += nums[i];
            res += i*nums[i];
        }
        f0 = res;


        int endsum = 0;
        for(int i = 1; i<n; i++){
            endsum += nums[n-i];
            int cur = f0 + i*sum -n*endsum;
            res = Math.max(res, cur);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxRotateFunction(new int[]{100}));
        System.out.println(maxRotateFunction(new int[]{4,3,2,6}));
    }
}
