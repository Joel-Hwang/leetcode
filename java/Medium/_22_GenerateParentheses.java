package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.testng.annotations.Test;

public class _22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int[] ar = new int[n * 2];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = i;
        }

        List<List<Integer>> res = new ArrayList<>();
        combination2(ar, 0, n, new ArrayList<>(), res);
        for (List<Integer> row : res) {
            char[] arRow = new char[n*2];
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i<arRow.length; i++){
                arRow[i] = '(';
            }
            for (int i: row) {
                arRow[i] = ')';
            }
            sb.append(arRow);
            if(isValid(sb.toString())){
                result.add(sb.toString());
            }
        }
        return result;
    }

    public void combination2(int[] ar, int start, int pick, List<Integer> parent, List<List<Integer>> res) {
        if (pick < 1) {
            res.add(new ArrayList<>(parent));
            return;
        }
        for (int i = start; i < ar.length - (pick - 1); i++) {
            parent.add(ar[i]);
            combination2(ar, i + 1, pick - 1, parent, res);
            parent.remove(parent.size() - 1);
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cPop;
            switch (s.charAt(i)) {
                case '(':
                    stk.push(s.charAt(i));
                    break;
                case ')':
                    if (stk.size() == 0)
                        return false;
                    cPop = stk.pop();
                    if (cPop != '(')
                        return false;
                    break;
            }
        }

        if (stk.size() > 0)
            return false;
        return true;

    }

    
    /*
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    */
    

    @Test
    public void test() {
        generateParenthesis(3);
    }
}
