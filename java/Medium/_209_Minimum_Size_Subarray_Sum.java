package Medium;

public class _209_Minimum_Size_Subarray_Sum {
    public _209_Minimum_Size_Subarray_Sum() {
        int len = minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 });
        System.out.println(len);
    }

    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                    System.out.println(String.format("i: %d, j:%d, k:%d", i,j,k));
                }
                if (sum >= target) {
                    ans = Math.min(ans, (j - i + 1));
                    break; // Found the smallest subarray with sum>=s starting with index i, hence move to
                           // next index
                }
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
