package Easy;

import org.testng.annotations.Test;

public class _415_AddString {
    public String addStrings(String num1, String num2) {
        char[] arNum1 = num1.toCharArray();
        char[] arNum2 = num2.toCharArray();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<Math.max(arNum1.length, arNum2.length); i++){
            int n1 = arNum1.length-i > 0 ? arNum1[arNum1.length-1-i]-'0' : 0;
            int n2 = arNum2.length-i > 0 ? arNum2[arNum2.length-1-i]-'0' : 0;
            int n3 = n1 + n2 + carry;
            sb.insert(0, n3%10);
            carry = n3/10;
        }
        if(carry>0) sb.insert(0, carry);
        return sb.toString();
    }

    public String addStrings2(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

    @Test
    public void test(){
        System.out.println(addStrings("11","123"));
        System.out.println(addStrings("456","77"));
        System.out.println(addStrings("0","0"));
    }
}
