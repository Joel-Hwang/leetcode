package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

public class _41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int cntPos = 0;
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for(int n : nums){
            if(n<=0) continue;
            cntPos++;
            hm.putIfAbsent(n, true);
        }
        for(int i = 1; i<=nums.length; i++){
            if(!hm.getOrDefault(i, false)) return i;
        }
        return cntPos+1;
    }

    // 5,4,3,2가 있으면 배열의 인덱스에 있다고 마크를 찍어줌
    // [x,o,o,o,o] 그리고 for 돌면서 x가 발견되면 리턴. 발견 안되면 n+1 리턴
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;

        for(int i = 0; i<n; i++){
            if(nums[i]<=0 || nums[i]> n) nums[i] = n+1;
        }
        for(int i = 0; i<n; i++){
            int num = Math.abs(nums[i]);
            if(num > n) continue;
            num--;
            if(nums[num]>0) nums[num] = -1*nums[num];
        }
        for(int i = 0; i<n; i++){
            if(nums[i]>0) return i+1;
        }
        return n+1;
    }

    @Test
    public void test(){
        assertEquals(firstMissingPositive2(new int[]{1,2,0}),3);
    }
}
