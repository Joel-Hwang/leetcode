import java.util.regex.Pattern;

public class Atoi {
    public Atoi(){
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("3.1415"));
        
    }

    public int myAtoi(String str) {
        String s = str.trim();

        if(str.matches("\\d+[a-zA-Z_0-9\\s\\.]+")){
            s = str.replaceAll("[a-zA-Z\\s\\.]", "");
        }

        if(str.matches("[a-zA-Z\\s]+\\d+")){
            return 0;
        }

        long a = Long.parseLong(s);
        if (a < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (a > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return Integer.parseInt(s);
    }
    
}