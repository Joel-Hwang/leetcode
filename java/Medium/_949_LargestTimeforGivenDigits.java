package Medium;

import org.testng.annotations.Test;

public class _949_LargestTimeforGivenDigits {
    public String largestTimeFromDigits(int[] arr) {
        StringBuilder res = new StringBuilder();
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            swap(arr,0,i);
            for(int j = 1; j<arr.length; j++){
                swap(arr,1,j);
                for(int k = 2; k<arr.length; k++){
                    swap(arr,2,k);
                   // System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
                    int curMin = arr[2]*10 + arr[3];
                    int cur = arr[0]*1000 + arr[1]*100 + curMin;
                    if(cur < 2400 && curMin < 60 && 2400 - cur < diff){
                        diff = 2400-cur;
                        res = new StringBuilder();
                        res.append(arr[0]);
                        res.append(arr[1]);
                        res.append(":");
                        res.append(arr[2]);
                        res.append(arr[3]);
                    }
                    swap(arr,k,2);
                }
                swap(arr,j,1);
            }
            
            swap(arr,i,0);
            
            
        }

        return res.toString();
    }

    public void swap(int[] ar, int a, int b){
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }


    @Test
    public void test(){
        System.out.println(largestTimeFromDigits(new int[]{1,9,6,0}));
    }

    

    
}
