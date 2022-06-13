package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _405_ConvertaNumberToHexadecimal {

    public String toHex2(int num) {
        if(num == 0) return "0";
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }


    public String toHex(int num) {
        if(num==0) return "0";
        if(num<0) return getNegativeHex(num);
        if(num>0) return getPositiveHex(num);
        return "";
    }

    private String getNegativeHex(long num){
        num += 2l*Integer.MAX_VALUE + 2;
        return getPositiveHex(num);
    }

    private String getPositiveHex(long num){
        StringBuilder sb = new StringBuilder();
        char[] digits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        while(num>0){
            sb.insert(0, digits[(int)(num%digits.length)]);
            num /= digits.length;  
        }
        return sb.toString();
    }

    

    @Test
    public void test(){
        assertEquals("ffffffff", toHex(-1));
        assertEquals("1a", toHex(26));
    }
}

/*
1 : 2^32
2 : 2^31-1

*/