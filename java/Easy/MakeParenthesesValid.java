package Easy;
import java.util.Stack;

public class MakeParenthesesValid {
    public MakeParenthesesValid(){
        System.out.println(minAddToMakeValid("())"));
    }

    public int minAddToMakeValid(String S) {
        Stack<Character> stk = new Stack<>();
        int res = 0;
        for(char c : S.toCharArray()){
            if(c == '('){
                stk.push(')');
            }else{
                if(!stk.empty())
                    stk.pop();
                else   
                    res++;
            }
        }
        return stk.size() + res;
    }
/*
    int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
    */
}
