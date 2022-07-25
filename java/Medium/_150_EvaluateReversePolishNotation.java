package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        List<String> tokenList = new ArrayList<>();
        for(String token : tokens) tokenList.add(token);

        for(int i = 2; i<tokenList.size(); i++){
            if( isOperator(tokenList.get(i)) ){
                int tempRes = calculate(tokenList.get(i), tokenList.get(i-2), tokenList.get(i-1));
                tokenList.set(i, ""+tempRes);
                tokenList.remove(i-1);
                tokenList.remove(i-2);
                i = i-3;
            }
        }

        return Integer.parseInt(tokenList.get(0));
    }

    private boolean isOperator(String s){
        return "+-*/".contains(s);
    }

    private int calculate(String op, String s1, String s2){
        if(!isOperator(op)) throw new ArithmeticException();
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        switch (op.toCharArray()[0]){
            case '+':
                return n1+n2;
            case '-':
                return n1-n2;
            case '*':
                return n1*n2;
            case '/':
                return n1/n2;
        }
        return 0;
    }


    @Test
    public void test(){
        assertEquals(22, evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        assertEquals(9, evalRPN(new String[]{"2","1","+","3","*"}));
    }

}
