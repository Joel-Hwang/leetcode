package Medium;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Stack;

import org.testng.annotations.Test;

public class _946_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushCur = 0;
        Stack<Integer> stk = new Stack<>();
        for(int popCur = 0; popCur<popped.length; popCur++){
            while(stk.empty() || stk.peek() != popped[popCur]){
                if(pushCur >= pushed.length) return false;
                stk.push(pushed[pushCur++]);
            }
            if(stk.peek() == popped[popCur]) stk.pop();
        }
        return true;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }

    @Test
    public void test(){
        assertTrue(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        assertFalse(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
}
