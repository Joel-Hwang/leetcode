package Hard;

import java.util.Arrays;

public class _480_SlidingWindowMedian{
    public _480_SlidingWindowMedian(){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        medianSlidingWindow2(nums, 3);
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

    public double[] medianSlidingWindow2(int[] nums, int k) {
        double[] res = new double[nums.length-k+1];
        int[] prevSubNum = null;
        for(int i = 0; i<nums.length-k+1; i++){
            int[] subNum = getSub2(nums,k,i,prevSubNum);
            prevSubNum = subNum;
            res[i] = getMedian(subNum);
        }
        return res;
    }

    public int[] getSub2(int[] nums,int k,int start, int[] prevSubNum){
        int[] subNum = new int[k];
        
        if(start == 0){
            for(int i = 0; i<k; i++){
                subNum[i] = nums[i];
            }
            Arrays.sort(subNum);
            return subNum;
        } 
        else{
            subNum = getNewSub(prevSubNum,nums[start-1],  nums[start+k-1]);
        }
        return subNum;
    }

    public int[] getNewSub(int[] num, int o, int n){
        //int[] num = {2,2,2,3,4,5};
        //int o = num[0];
        //int n = 1;
        if(n == o) return num;

        if(n>o){
            for(int i = 0; i<num.length; i++){
                if(num[i]>n){
                    num[i-1] = n;
                    break;
                }
                if(i == num.length-1){
                    num[i] = n;
                    break;
                }
                if(num[i] >= o && num[i] <= n){
                    num[i] = num[i+1];
                }
            }
        }else{
            for(int i = num.length-1; i>=0; i--){
                if(num[i]<n){
                    num[i+1] = n;
                    break;
                } 
                if(i == 0){
                    num[i] = n;
                    break;
                }
                if(num[i] <= o && num[i] >= n){
                    num[i] = num[i-1];
                }
            }
        }
        return num;
            
    }
}