package Hard;

import java.util.Arrays;

public class _480_SlidingWindowMedian{
    public _480_SlidingWindowMedian(){
        int[] nums = {2147483647,2147483647};
        medianSlidingWindow(nums, 2);
    }
    //Time Complex O(N*MlogM)
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length-k+1];
        for(int i = 0; i<nums.length-k+1; i++){
            int[] subNum = getSub(nums,k,i);
            Arrays.sort(subNum);
            res[i] = getMedian(subNum);
        }
        return res;
    }

    public int[] getSub(int[] nums,  int k,int start){
        int[] subNum = new int[k];
        for(int i = 0; i<k; i++){
            subNum[i] = nums[start+i];
        }
        return subNum;
    }

    public double getMedian(int[] subNum){
        if(subNum.length%2==1) return subNum[subNum.length/2];
        else return subNum[subNum.length/2]/2.0 + subNum[subNum.length/2-1]/2.0;
    }
}