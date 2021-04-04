package Hard;

import java.util.Stack;

public class _32_Longest_Valid_Parentheses {
    public _32_Longest_Valid_Parentheses(){
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(()"));
    }

    public int longestValidParentheses(String s) {
        int res = 0;
        int curRes = 0;
        char[] arC = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for(char c : arC){
            if(c=='('){
                stk.push(c);
                continue;
            } 

            if(stk.size() == 0){
                res = Math.max(res, curRes);
                curRes = 0;
                continue;
            }
            else{
                stk.pop();
                curRes+=2;
            }    
                
        }
        res = Math.max(res, curRes);
        return res;
    }
}
