package Hard;

public class _1330_ReverseSubarrayToMaximizeArrayValue {
    public int maxValueAfterReverse(int[] nums) {
        
        int total = 0;
        int case1 = 0;
        int max2 = -100001;
        int min2 = 100001;
        for(int i = 0; i<nums.length-1;i++){
            int a = nums[i];
            int b = nums[i+1];
            total+= Math.abs(a-b);
            case1 = Math.max(case1, Math.abs(b-nums[0]) - Math.abs(a-b));
            case1 = Math.max(case1, Math.abs(a-nums[nums.length-1]) - Math.abs(a-b));
            min2 = Math.min(min2,Math.max(a,b));
            max2 = Math.max(max2,Math.min(a,b));
        
        }
        return total + Math.max(case1, 2*(max2-min2));
    }
}
