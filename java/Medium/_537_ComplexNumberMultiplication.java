package Medium;

import org.testng.annotations.Test;

public class _537_ComplexNumberMultiplication {
    public String complexNumberMultiply2(String num1, String num2) {
        String res = "";
        Num n1 = parse(num1);
        Num n2 = parse(num2);
        int digit = n1.digit * n2.digit - n1.imagine * n2.imagine;
        int imagine = n1.digit * n2.imagine + n2.digit * n1.imagine;
        int op = Math.max(n1.op, n2.op);
        String sOp = "+";
        return digit + sOp + imagine + "i";
    }

    private Num parse(String num) {
        int digit = 0;
        int op = num.contains("+-") ? 2 : num.contains("-") ? 1 : 0;
        int imagine = 0;
        for (int i = 0; i < num.length(); i++) {

            if ((num.charAt(i) == '+' || num.charAt(i) == '-')) {
                if(i==0) continue;
                digit = Integer.parseInt(num.substring(0, i));
                int start = op == 2 ? i + 1 : i + 0;
                imagine = Integer.parseInt(num.substring(start, num.length() - 1));
                break;
            }
        }
        return new Num(digit, imagine, op);
    }

    public String complexNumberMultiply(String a, String b) {
        String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);
        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";

    }

    class Num {
        int digit;
        int imagine;
        int op; // 0:+ 1:- 2:+-

        public Num(int digit, int imagine, int op) {
            this.digit = digit;
            this.imagine = imagine;
            this.op = op;
        }
    }

    @Test
    public void test() {
        System.out.println(complexNumberMultiply("78+-76i", "-86+72i"));
        System.out.println(complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }
}