package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;


public class _2064_MinimizedMaximumOfProductsDistributedToAnyStore {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 100000;
        while(left < right){
            int mid = (left+right)/2;
            int sum = 0;
            for(int quantity : quantities)
                sum += (int)Math.ceil((double)quantity/mid);
            if(sum > n)
                left = mid+1;
            else
                right = mid;
        }

        return left;
    }
    @Test
    public void test(){
        assertEquals(3,minimizedMaximum(6,new int[]{11,6}));
        assertEquals(5,minimizedMaximum(7,new int[]{15,10,10}));
        assertEquals(100000,minimizedMaximum(1,new int[]{100000}));
        assertEquals(1,minimizedMaximum(100000,new int[]{4,4,4,2,4,2,4,1,5,4,5,4,1,1,2,2,4,1,1,4,5,3,3,4,1,2}));
    }
}
