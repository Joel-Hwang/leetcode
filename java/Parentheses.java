import java.util.Stack;

public class Parentheses {


    public boolean isValid(String s) {
      Stack<Character> stk = new Stack<>();
    
      for(int i = 0; i<s.length(); i++){
          char cPop;
          switch(s.charAt(i)){
              case '(':
              case '[':
              case '{':
                  stk.push(s.charAt(i));
                      
                  break;
              case ')':
                  if(stk.size()==0) return false;
                  cPop = stk.pop();
                  if(cPop != '(') return false;
                  break;
              case ']':
                  if(stk.size()==0) return false;
                  cPop = stk.pop();
                  if(cPop != '[') return false;
                  break;
              case '}':
                  if(stk.size()==0) return false;
                  cPop = stk.pop();
                  if(cPop != '{') return false;
                  break;
          }
      }
        
      if(stk.size()>0) return false;
      return true;
        
    }
}


/*

public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}

*/