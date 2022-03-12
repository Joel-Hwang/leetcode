package Hard;
import java.util.*;

public class _224_BasicCalculator {
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stk = new Stack<Integer>();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }else if(c == '+'){
                res += sign*num;
                num=0;
                sign = 1;
            }else if(c == '-'){
                res += sign*num;
                num=0;
                sign = -1;
            }else if(c == '('){
                stk.push(res);
                stk.push(sign);
                res=0;
                sign=1;
            }else if(c == ')'){
                res += sign*num;
                res *= stk.pop();
                res += stk.pop();
                num=0;
            }
        }

        if(num != 0) res += sign*num;
        return res;
    }
}
