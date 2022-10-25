package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _1574_ShortestSubarrayToBeRemovedToMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0, r = 0;
        int res = arr.length-1;
        for(int i = 1; i<arr.length; i++)
            if( arr[i-1] > arr[i] ){
                l = i-1;
                break;
            }

        for(int i = arr.length-2; i >=0; i--)
            if(arr[i] > arr[i+1]){
                r = i+1;
                break;
            }

        if(l == 0 && r == 0) return 0;

        res = Math.min(res,arr.length-l-1);
        for(int i = l; i>=0; i--){
            if(arr[i] <= arr[r]){
                res = Math.min(res,r-i-1);
            }
        }
        
        res = Math.min(res,r);
        for(int i = r; i<arr.length; i++){
            if(arr[l] <= arr[i]){
                res = Math.min(res,i-l-1);
            }
        }

        while(l>=0 && r<arr.length){
            
            if(arr[l] <= arr[r]){
                res = Math.min(res,r-l-1);
                break;
            }
            if(r<arr.length-1 && arr[l] <= arr[r+1]){
                res = Math.min(res,r-l);
                break;
            }
            if(l>0 && arr[l-1] <= arr[r]){
                res = Math.min(res,r-l);
                break;
            }

            l--;
            r++;
        }
        
        return res;
    }


    @Test
    public void test(){
        assertEquals(7, findLengthOfShortestSubarray(new int[]{10,13,17,21,15,15,9,17,22,22,13}));
        assertEquals(4, findLengthOfShortestSubarray(new int[]{5,4,3,2,1}));
        assertEquals(2, findLengthOfShortestSubarray(new int[]{1,2,3,10,0,7,8,9}));
        assertEquals(3, findLengthOfShortestSubarray(new int[]{2,2,2,1,1,1}));
        assertEquals(0, findLengthOfShortestSubarray(new int[]{1,2,3}));
        assertEquals(3, findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
    }
}
