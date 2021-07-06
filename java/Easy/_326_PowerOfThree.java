package Easy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        double a = Math.log10(n)/Math.log10(3);
        return a%1==0;
    }

    @Test
    public void test(){
        assertTrue(isPowerOfThree(9));
        assertFalse(isPowerOfThree(8));
        assertTrue(isPowerOfThree(243));
    }
}
