package Easy;

public class _905_SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int l = -1, r = nums.length;
        for(int n : nums){
            if(n%2==0){
                res[++l] = n;
            }else{
                res[--r] = n;
            }
        }
        return res;
    }
}
