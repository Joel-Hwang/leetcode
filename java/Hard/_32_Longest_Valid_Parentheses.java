package Hard;
import java.util.Stack;

public class _32_Longest_Valid_Parentheses {
    public _32_Longest_Valid_Parentheses(){
        //System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")))()())"));
        System.out.println(longestValidParentheses("()(()"));
    }
    /*
    stk에 -1 push
    ( 를 만나면 index를 push
    ) 를 만나면 pop하고 res = index - 스택의 꼭대기
       () 케이스면 res = 2가 될거임
    만약 스택이 비었다면 현재까지 계산된 지점을 기록하기 위해 ) 의 index를 push 
    */
    public int longestValidParentheses(String s) {
        int res = 0;
        
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        for(int i = 0; i<s.length(); i++){
            String curS = s.substring(i, i+1);
            if("(".equals(curS)) stk.push(i);
            else{
                stk.pop();
                if(stk.empty()){
                    stk.push(i);
                }else{
                    res = Math.max(res, i - stk.peek());
                }
            } 
        }
        return res;
    }
}
