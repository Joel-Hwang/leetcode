package Medium;
import java.util.regex.Pattern;

public class Atoi {
    public Atoi() {

       // System.out.println(myAtoi("  0000000000012345678"));
        //System.out.println(myAtoi("0-1"));
        System.out.println(myAtoi("-000000000000000000000000000000000000000000000000001"));
        System.out.println(myAtoi("+-2"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("3.1415"));

    }

    public int myAtoi(String str) {
        str = str.trim();
        String result = "";
        if (str.contains("+-") || str.contains("-+")) return 0;
        if (str.startsWith("+")) str = str.replaceFirst("\\+", "");
        boolean isMinus = true;
        if(str.startsWith("-")){
            str = str.replaceFirst("-", "");
            isMinus = true;
        }else{
            isMinus = false;
        }

        String a = "0123456789";
        for (int i = 0; i < str.length(); i++) {
            if (a.contains("" + str.charAt(i))) {
                result += str.charAt(i);
            } else {
                break;
            }
        }
        
        if (isMinus) {
            result = removeZero(result);
            result = "-" + result;
        } else {
            result = removeZero(result);
        }

        if ("-".equals(result))
            return 0;
        if (!result.startsWith("-") && result.length() > 11)
            return Integer.MAX_VALUE;
        if (result.startsWith("-") && result.length() > 11)
            return Integer.MIN_VALUE;
        if (result.length() > 0 && (Long.parseLong(result) > Integer.MAX_VALUE))
            return Integer.MAX_VALUE;
        if (result.length() > 0 && (Long.parseLong(result) < Integer.MIN_VALUE))
            return Integer.MIN_VALUE;

        try {
            return result.length() == 0 ? 0 : Integer.parseInt(result);
        } catch (NumberFormatException er) {
            return 0;
        }
    }

    public String removeZero(String result) {
        while(result.startsWith("0")){
            result = result.replaceFirst("0", "");
        }
        return result;
    }

}