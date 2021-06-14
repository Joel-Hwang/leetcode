package Easy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _168_ExcelSheetColumnTitle {
    public String convertToTitle(int col) {

        //col++;
        String getColResult = "";
        String[] seq = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
                "T", "U", "V", "W", "X", "Y", "Z" };

        do {
            int remain = col % seq.length;
            col = col / seq.length;
            if (remain == 0) {
                remain = 26;
                col--;
            }
            getColResult = seq[remain - 1] + getColResult;
        } while (col >= seq.length);

        if (col > 0) {
            getColResult = seq[col - 1] + getColResult;
        }
        return getColResult;
    }

    @Test
    public void test(){
        assertTrue("A".equals(convertToTitle(1)));
        assertTrue("AB".equals(convertToTitle(28)));
        assertTrue("ZY".equals(convertToTitle(701)));
        assertTrue("FXSHRXW".equals(convertToTitle(2147483647)));
    }

    public String convertToTitle2(int n) {
        return n == 0 ? "" : convertToTitle2(--n / 26) + (char)('A' + (n % 26));
    }
 
}
