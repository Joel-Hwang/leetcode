package Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class _869_ReorderedPowerof2 {
    public boolean reorderedPowerOf2(int n) {
        int[] transformedN = transform(n);
        for(int i = 1; i<1e9; i*=2){
            int[] cur = transform(i);
            if(Arrays.equals(transformedN, cur)) return true;
        }
        return false;
    }

    private int[] transform(int n){
        int[] ar = new int[10];
        while(n > 0){
            int d = n % 10;
            ar[d]++;
            n /= 10;
        }

        return ar;
    }

    @Test
    public void test(){
        System.out.println(reorderedPowerOf2(46));
    }
}
