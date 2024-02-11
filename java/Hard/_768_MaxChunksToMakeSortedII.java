package Hard;

import org.testng.annotations.Test;

public class _768_MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;

        for(int i = 0; i<arr.length; i++){
            int maxSmallerElementIndex = i;
            int maxElementIndex = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[maxElementIndex] < arr[j]) maxElementIndex = j;
                if(arr[i] > arr[j]) maxSmallerElementIndex = j;

                if(maxElementIndex != i && maxElementIndex < maxSmallerElementIndex){
                    i = maxElementIndex;
                    j = i;
                    maxSmallerElementIndex = i;
                    maxElementIndex = i;
                }
            }
            i = maxSmallerElementIndex;
            result++;
        }

        return result;
    }

    @Test
    public void test(){
        System.out.println(maxChunksToSorted(new int[]{5,1,1,8,1,6,5,9,7,8}));
        System.out.println(maxChunksToSorted(new int[]{5,4,3,2,1}));
        System.out.println(maxChunksToSorted(new int[]{2,1,3,4,4}));
    }
}
