package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _1526_MinimumNumberIncrementsSubarraysFormTargetArray {
 /*
 
3     1      4     5     2     1     4

3     0      3     1     0     0     3

3    3>1    4-1  5-4  5>2  2>1  4-1 
 
 */
    public int minNumberOperations(int[] target) {
        int res = target[0];
        for(int i = 1; i<target.length; i++){
            if(target[i] >= target[i-1]) 
                res = res + (target[i] - target[i-1]);
            System.out.println(res);
        }
        return res;
    }
    @Test
    public void test(){
        assertEquals(10, minNumberOperations(new int[]{3,1,4,5,2,1,4}));
    }
}