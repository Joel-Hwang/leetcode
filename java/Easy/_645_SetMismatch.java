package Easy;

public class _645_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] map = new int[nums.length];
        for(int n : nums){
            map[n-1]++;
            if(map[n-1]>1) res[0] = n;
        }

        for(int i = 0; i<map.length; i++){
            if(map[i] == 0) res[1] = i+1;
        }
        return res;
    }
}
