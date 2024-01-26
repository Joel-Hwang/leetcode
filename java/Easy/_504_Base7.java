package Easy;

import org.testng.annotations.Test;

public class _504_Base7 {
    public String convertToBase7(int num) {
        StringBuffer result = new StringBuffer();
        boolean isMinus = false;
        if(num<0) isMinus = true;
        if(isMinus) num *= -1;
        do{
            int cur = num%7;
            num /= 7;
            result.insert(0,cur);
        }while(num>0);
        if(isMinus)result.insert(0,"-");
        return result.toString();
    }

    @Test
    private void test(){
        System.out.println(convertToBase7(0));
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
    }
}
