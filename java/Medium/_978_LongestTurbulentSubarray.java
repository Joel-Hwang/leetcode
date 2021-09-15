package Medium;

import org.testng.annotations.Test;

public class _978_LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        int cur = 1;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] == arr[i-1]) cur = 1;
            else if(i>1 &&  
                ( (arr[i-2] > arr[i-1] && arr[i-1] < arr[i])  
                || (arr[i-2] < arr[i-1] && arr[i-1] > arr[i]) )    
            ){
                cur++;
            }else{
                cur = 2;
            }

            res = Math.max(res, cur);
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        System.out.println(maxTurbulenceSize(new int[]{4,8,12,16}));
        System.out.println(maxTurbulenceSize(new int[]{100}));
        System.out.println(maxTurbulenceSize(new int[]{8,8}));
    }
}
