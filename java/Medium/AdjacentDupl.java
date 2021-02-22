package Medium;
import java.util.Stack;

public class AdjacentDupl {
    public AdjacentDupl() {
        System.out.println(removeDuplicates("abbaca"));
    }

    // 초기코드(134ms, 41.1MB)
    public String removeDuplicates(String S) {
        Stack<Character> stk = new Stack<>();
        for (char c : S.toCharArray()) {

            if (stk.size() > 0 && stk.peek() == c)
                stk.pop();
            else
                stk.push(c);
        }
        String res = "";
        while (!stk.isEmpty()) {
            res = stk.pop() + res;

        }
        return res;
    }

    // StringBuilder로 변경(50ms, 39.6MB))
    public String removeDuplicates2(String S) {
        Stack<Character> stk = new Stack<>();
        for (char c : S.toCharArray()) {

            if (stk.size() > 0 && stk.peek() == c)
                stk.pop();
            else
                stk.push(c);
        }
        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty()) {
            res.insert(0, stk.pop());
        }
        return res.toString();
    }

    // While문 제거로 최적화(insert 함수 대신 append) ( 12ms,39.4MB )

    public String removeDuplicates3(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
                sb.deleteCharAt(sb.length() - 1);
            } else {
                stack.push(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
