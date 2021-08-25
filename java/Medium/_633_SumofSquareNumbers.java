package Medium;

import org.testng.annotations.Test;

public class _633_SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++) {
            if (isExist(c - i * i))
                return true;
        }
        return false;
    }

    public boolean isExist(int power) {
        double power2 = Math.sqrt(power);
        return power2 == (int)power2;
    }

    @Test
    public void test() {
        System.out.println(judgeSquareSum(0));
        System.out.println(judgeSquareSum(1));
        System.out.println(judgeSquareSum(2));
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(2147483646));
    }
}