package Medium;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class _969_PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<Integer>();
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        for(int i = arr.length-1; i >= 0; i--){
            if(arr[i] == sortedArr[i]) continue;
            int[] arIdx = getFlipIdxs(arr,sortedArr[i],i+1);
            for(int idx : arIdx){
                result.add(idx);
                flip(arr, idx);
            }
        }

        return result;
    }

    private int[] getFlipIdxs(int[] ar, int targetNum, int targetIdx ){
        int idx = findIndex(ar, targetNum);
        if(idx == 0) return new int[]{targetIdx};
        else return new int[]{idx+1, targetIdx};
    }

    private int findIndex(int[] ar, int targetNum){
        for(int i=0; i<ar.length; i++){
            if(ar[i] == targetNum) return i;
        }
        return -1;
    }
    private void flip(int[] ar, int k){
        for(int i = 0; i < k/2; i++){
            int temp = ar[i];
            ar[i] = ar[k-1-i];
            ar[k-1-i] = temp;
        }
    }

    @Test
    public void test(){
        pancakeSort(new int[]{3,2,4,1});

    }

}
