package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _461_HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int res = 0;
        while(z > 0){
            if(z%2 == 1) res++;
            z = z >> 1;
        }
        return res;
    }

    @Test
    public void test(){
        assertEquals(2,hammingDistance(1, 4));
    }
}
