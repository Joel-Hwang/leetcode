package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i = 0; i<n; i++){
            int remainedGas = 0;
            for(int j = 0; j<n; j++){
                int iGas = remainedGas+gas[(i+j)%n];
                int iCost = cost[(i+j)%n];
                remainedGas = iGas - iCost;
                if(remainedGas<0) break;
            }
            if(remainedGas>=0) return i;
        }
        return -1;   
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0, curTotal = 0, res = 0;
        for(int i = 0; i<gas.length; i++){
            int cur = gas[i] - cost[i];
            sum += cur;
            curTotal+= cur;
            if(curTotal<0){
                res = i+1;
                curTotal = 0;
            }
        }
        return sum<0?-1:res;
    }

    @Test
    public void test(){
        assertEquals(
            canCompleteCircuit2(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2})
        ,3);
    }
}
