package Easy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.testng.annotations.Test;

public class _1089_DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int zeroCnt = 0;
        int nonZeroCnt = 0;
        int lastIdx = 0;
        for(int i = 0; i+zeroCnt<arr.length; i++){
            if(arr[i] == 0) zeroCnt++;
            else nonZeroCnt++;
            
            lastIdx = i;
        }

        
        int odd = 0;
        if(arr[lastIdx] == 0 && zeroCnt*2+nonZeroCnt > arr.length){
            arr[arr.length-1] = 0;
            lastIdx--;
            odd = 1;
        }
        for(int i = arr.length-1-odd; i>=0; i--){
            arr[i] = arr[lastIdx];
            if(arr[lastIdx--] == 0){
                arr[--i] = 0;
            }
        }
    }

    @Test
    public void test(){
        int[] ori = {};

        ori = new int[]{0};
        duplicateZeros(ori);
        assertArrayEquals(new int[]{0},ori);

        ori = new int[]{0,0};
        duplicateZeros(ori);
        assertArrayEquals(new int[]{0,0},ori);


        ori = new int[]{0,1,0,0};
        duplicateZeros(ori);
        assertArrayEquals(new int[]{0,0,1,0},ori);

        ori = new int[]{0,0,0,0,0,0};
        duplicateZeros(ori);
        assertArrayEquals(new int[]{0,0,0,0,0,0},ori);

        ori = new int[]{0,0,0,0,0,0,0};
        duplicateZeros(ori);
        assertArrayEquals(new int[]{0,0,0,0,0,0,0},ori);

        ori = new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros(ori);
        assertArrayEquals(new int[]{1,0,0,2,3,0,0,4},ori);

        ori = new int[]{1,2,3};
        duplicateZeros(ori);
        assertArrayEquals(new int[]{1,2,3},ori);
    }
}
