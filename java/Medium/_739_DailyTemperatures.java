package Medium;

import java.util.Arrays;
import java.util.Stack;

import org.testng.annotations.Test;

public class _739_DailyTemperatures {
    public int[] dailyTemperatures(int[] t) {
        int[] res = new int[t.length];
        //스택에 무조건 decrease order로 저장된다.
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<t.length; i++){

            while(!stack.isEmpty() && t[stack.peek()] < t[i]){
                res[stack.peek()] = i- stack.peek();
                stack.pop();
            }


            if(i+1<t.length && t[i] < t[i+1]) res[i] = 1;
            else{
                stack.push(i);
            }
        }

        return res;
    }

    public int[] dailyTemperatures2(int[] t) {
        int[] res = new int[t.length];

        for(int i = 0; i<t.length-1; i++){
            for(int j = i+1; j<t.length; j++){
                if(t[i] < t[j]){
                    res[i] = j-i;
                    break;
                } 
            }    
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{77,77,77,77,77,41,77,41,41,77})));
    }
}