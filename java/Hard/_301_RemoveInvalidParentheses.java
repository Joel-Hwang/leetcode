package Hard;

import java.util.*;

import org.testng.annotations.Test;

public class _301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList();
        Set<String> visited = new HashSet();
        Queue<String> q = new LinkedList();
        visited.add(s);
        q.add(s);
        boolean flag = false;
        while(q.size()>0){
            String strQ = q.poll();
            if(isValid(strQ)){
                res.add(strQ);
                flag = true;
                continue;
            }
            if(flag) continue;

            //invalid case
            for(int i = 0; i<strQ.length(); i++){
                if(strQ.charAt(i) == ')' || strQ.charAt(i) == '(' ){
                    String newStr = strQ.substring(0, i).concat(strQ.substring(i+1));
                    if(!visited.contains(newStr)){
                        visited.add(newStr);
                        q.add(newStr);
                    }
                } 
            }
        }

        return res;
    }

    public boolean isValid(String s){
        int cnt = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '(' ) cnt++;
            else if(s.charAt(i) == ')' ) cnt--;

            if(cnt<0) return false;
        }
        return cnt == 0;
    }

    @Test
    public void test(){
        List<String> validP = removeInvalidParentheses("()())()");
        for(String s : validP) System.out.println(s);
    }
}
