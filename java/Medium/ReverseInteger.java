package Medium;
public class ReverseInteger {
    public ReverseInteger() {
        // System.out.println(reverse(123));
        // System.out.println(reverse(-123));
        // System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }

    public int reverse(int x) {
        if (x == 0)
            return x;
        String sResult = "";
        boolean isPos = x >= 0 ? true : false;
        x = Math.abs(x);
        while (x > 0) {
            sResult += x % 10;
            x /= 10;
        }
        try {
            return Integer.parseInt((isPos ? "" : "-") + sResult);
        } catch (Exception e) {
            return 0;
        }

    }


    /*
     public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
    
    */
}