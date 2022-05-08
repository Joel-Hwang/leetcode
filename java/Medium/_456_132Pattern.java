package Medium;

import java.util.Stack;

public class _456_132Pattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int third = Integer.MIN_VALUE;
        for (int i = nums.length-1; i >=0; i--){
            if(nums[i] < third) return true;
            while(!stk.isEmpty() && nums[i] > stk.peek()) third = stk.pop();
            stk.push(nums[i]);
        }
        return false;
    }
}
