package Easy;

import org.testng.annotations.Test;

public class _258_AddDigits {
    public int addDigits(int num) {
        int result = 0;

        do {
            result = 0;
            while (num > 0) {
                int digit = num % 10;
                num /= 10;
                result += digit;
            }
            num = result;
        } while (result > 9);

        return result;
    }

    @Test
    public void test(){
        addDigits(38);
    }
}
