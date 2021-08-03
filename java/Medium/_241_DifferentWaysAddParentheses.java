package Medium;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;



public class _241_DifferentWaysAddParentheses {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i<input.length()-1; i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for(Integer p1 : part1Ret){
                    for(Integer p2 : part2Ret){
                        int curRes = 0;
                        switch(input.charAt(i)){
                            case '+':
                            curRes = p1+p2;
                            break;
                            case '-':
                            curRes = p1-p2;
                            break;
                            case '*':
                            curRes = p1*p2;
                            break;
                        }
                        ret.add(curRes);
                    }
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
