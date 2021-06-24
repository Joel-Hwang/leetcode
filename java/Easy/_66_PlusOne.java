package Easy;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _66_PlusOne {
    public int[] plusOne(int[] digits) {

        digits[digits.length-1]++;

        for(int i = digits.length-2; i>=0; i--){
            if(digits[i+1] > 9){
                digits[i+1] %= 10;
                digits[i]++;
            }
        }

        if(digits[0] > 9){
            int[] res = new int[digits.length+1];
            digits[0] %= 10;
            res[0] = 1;
            for(int i = 1; i<res.length; i++){
                res[i] = digits[i-1];
            }
            return res;
        }
        else return digits;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9})));
    }
}
