package Easy;

import org.testng.annotations.Test;

public class _171_ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        char[] arC = columnTitle.toCharArray();
        int res = 0;
        for(int i = arC.length-1, j=0; i>=0; i--, j++){
            int cur = arC[i]-'A' + 1;
            cur*=Math.pow(26, j);
            res += cur;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(titleToNumber("ZY"));
    }
}
