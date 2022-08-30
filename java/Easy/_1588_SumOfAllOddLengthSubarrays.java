package Easy;

import org.testng.annotations.Test;

public class _1588_SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int cnt = 1;
        while(cnt <= arr.length){
            res += getSumRow(cnt, arr);
            cnt+= 2;
        }
        
        return res;
    }

    private int getSumRow(int cnt, int[] arr){
        int res = 0;
        for(int i = 0; i<arr.length-cnt+1; i++){
            for(int j = 0; j<cnt; j++){
                res += arr[i+j];
            }
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
        System.out.println(sumOddLengthSubarrays(new int[]{1}));
        System.out.println(sumOddLengthSubarrays(new int[]{1,2}));
        System.out.println(sumOddLengthSubarrays(new int[]{1,2,3}));
        System.out.println(sumOddLengthSubarrays(new int[]{1,2,3,4}));
    }

}

