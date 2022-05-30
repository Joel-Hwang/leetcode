package Medium;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _1362_ClosestDivisors {
    public int[] closestDivisors2(int num) {
        int[] res = {0,Integer.MAX_VALUE};
        for(int j = 0; j<2; j++){
            num++;
            for(int i = 1; i<=Math.sqrt(num); i++) {
                setValidRes(num,i,res);
            }
        }
        return res;
    }

    private void setValidRes(int num, int i, int[] res){
        if(num%i==0){
            int firstNum = i;
            int secondNum = num/i;
            if(Math.abs(firstNum-secondNum) < Math.abs(res[0]-res[1])){

                res[0] = firstNum;
                res[1] = secondNum;
            }
        }
    }

    public int[] closestDivisors(int num) {
        for(int i = (int)Math.sqrt(num+2); i>0; i--){
            if( (num+1)%i == 0 ) return new int[]{i,(num+1)/i};
            if( (num+2)%i == 0 ) return new int[]{i,(num+2)/i};
        }

        return new int[]{};
    }


    @Test
    public void test(){
        assertArrayEquals(new int[]{3,3}, closestDivisors(8));
        assertArrayEquals(new int[]{5,25}, closestDivisors(123));
    }
}
