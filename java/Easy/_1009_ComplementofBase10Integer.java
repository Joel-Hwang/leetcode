package Easy;

import org.testng.annotations.Test;

public class _1009_ComplementofBase10Integer {
    public int bitwiseComplement(int n) {

        int len = Integer.toBinaryString(n).length();
        return (int)Math.pow(2, len)-1 - n;
    }

    @Test
    public void test(){
        System.out.println(bitwiseComplement(7));
    }
}
