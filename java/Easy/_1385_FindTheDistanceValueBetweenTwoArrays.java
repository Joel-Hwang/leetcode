package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.testng.annotations.Test;

public class _1385_FindTheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for(int a1 : arr1){
            int l = 0, r = arr2.length;
            while(l<r){
                int mid = (l+r)/2;
                if( a1-arr2[mid] > d ){
                    l = mid+1;
                }else if( arr2[mid] - a1 > d ){
                    r = mid;
                }else{
                    res++;
                    break;
                }
            }
        }
        return arr1.length-res;
    }

    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for(int a1 : arr1){
            for(int a2 : arr2){
                if(Math.abs(a1-a2) <= d){
                    res++;
                    break;
                }
            }
        }
        return arr1.length-res;
    }

    @Test
    public void test(){

        assertEquals(0, findTheDistanceValue(new int[]{4,-3,-7,0,-10}, new int[]{10}, 69));
        assertEquals(2, findTheDistanceValue(new int[]{4,5,8}, new int[]{10,9,1,8}, 2));

    }
}
