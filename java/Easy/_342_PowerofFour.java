package Easy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _342_PowerofFour {
    public boolean isPowerOfFour(int n) {
        double a = Math.log(n)/Math.log(4);
        return a == Math.round(a);
    }

    @Test
    public void test(){
        assertTrue(isPowerOfFour(16));
        assertFalse(isPowerOfFour(5));
        assertFalse(isPowerOfFour(17));
    }
}
