package Medium;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;



public class _241_DifferentWaysAddParentheses {
    Map<String,List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                String sp1 = input.substring(0, i);
                String sp2 = input.substring(i+1);
                List<Integer> lP1 = diffWaysToCompute(sp1);
                List<Integer> lP2 = diffWaysToCompute(sp2);
                for(Integer p1 : lP1)
                    for(Integer p2 : lP2){
                        int cRes = 0;
                        switch(input.charAt(i)){
                            case '+':
                            cRes = p1+p2;
                            break;
                            case '-':
                            cRes = p1-p2;
                            break;
                            case '*':
                            cRes = p1*p2;
                            break;
                        }
                        ret.add(cRes);
                    }
            }
        }

        if(ret.size() == 0) 
            ret.add(Integer.parseInt(input));
        map.put(input, ret);
        return ret;
    }


    @Test
    public void test(){
        diffWaysToCompute("2+3+4+5");
    }
}
