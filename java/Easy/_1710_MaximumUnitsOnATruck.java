package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _1710_MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (int[] a, int[] b) -> {
            return b[1] - a[1];
        });

        int res = 0;
        for(int[] box : boxTypes) {
            if(truckSize <= 0) break;
            
            if(truckSize >= box[0]){
                res += box[0]*box[1];
                truckSize -= box[0];
            }else{
                res += truckSize*box[1];
                truckSize = 0;
            }
        }

        return res;    
    }

    @Test
    public void test(){
        assertEquals(8, maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4));
    }
    
}
