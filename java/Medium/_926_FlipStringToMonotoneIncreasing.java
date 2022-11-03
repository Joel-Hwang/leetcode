package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.testng.annotations.Test;

public class _926_FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int res = s.length();
        int[] l=new int[s.length()+1];
        int[] r=new int[s.length()+1];
        l[0] = 0;
        r[r.length-1] = 0;
        for(int i = 1, j = r.length-2; i<l.length; i++, j--){
            l[i] = l[i-1];
            r[j] = r[j+1];
            if(s.charAt(i-1)=='1') l[i]++;
            if(s.charAt(j)=='0') r[j]++;
        }
        
        for(int i = 0; i<l.length; i++){
            res = Math.min(res,l[i]+r[i]);
        }
        return res;
    }

    @Test
    public void test(){
        assertEquals(3, minFlipsMonoIncr("0101100011"));
    }
}



/*
 0001100011011
 3   2  3 2 1 2

 000110001100
3 2 3 2 2

111000001110011
3 5 3 2 2 
 */