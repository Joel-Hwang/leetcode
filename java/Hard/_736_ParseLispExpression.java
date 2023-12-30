package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.testng.annotations.Test;

public class _736_ParseLispExpression {
    class StoredVariablesExpression{
        String expression;
        Map<String, Integer> values = new HashMap<>();
        public StoredVariablesExpression(String expression, Map<String, Integer> values){
            this.expression = expression;
            this.values = values;
        }
    }

    public int evaluate(String expression) {
        List<StoredVariablesExpression> list = new ArrayList<>();
        int start = 0;
        for(int i = 1; i<expression.length(); i++){
            if(expression.charAt(i) == '('){
                String subExpression = expression.substring(start+1, i).trim();

                doOpen(subExpression,list);

                start = i;
            }else if(expression.charAt(i) == ')'){
                String subExpression = expression.substring(start+1, i).trim();
                
                if(isOpenClose(expression,start))// (....)
                    doOpenClose(subExpression,list);
                else// ).....)
                    doCloseClose(subExpression,list);
                start = i;
            }else;
        } 
        int result = let(list.getFirst().expression,list);
        return result;

    }

    // (
    private void doOpen(String subExpression, List<StoredVariablesExpression> list){
        if(subExpression.trim().isEmpty()) return;
        if(isCommand(subExpression)){
            Map<String,Integer> curVar = currentVars(subExpression, list);
            StoredVariablesExpression sve = new StoredVariablesExpression(subExpression, curVar);
            list.add(sve);
        }else{
            StoredVariablesExpression lastOne = list.getLast();
            lastOne.expression = addExpression(lastOne.expression, subExpression);
            if(lastOne.expression.startsWith("let")) lastOne.values = currentVars(lastOne.expression, list);
            list.set(list.size()-1, lastOne);
        }
    }

    // (.....)
    private void doOpenClose(String subExpression, List<StoredVariablesExpression> list){
        int resultOfLet = action(subExpression, list);
        if(list.isEmpty()){
            StoredVariablesExpression sve = new StoredVariablesExpression(resultOfLet+"", null);
            list.add(sve);     
        }else{
            StoredVariablesExpression lastOne = list.getLast();
            lastOne.expression = addExpression(lastOne.expression, ""+resultOfLet);
            if(lastOne.expression.startsWith("let")) lastOne.values = currentVars(lastOne.expression, list);
            list.set(list.size()-1, lastOne);
        
        }
    }

    // )....)
    private void doCloseClose(String subExpression, List<StoredVariablesExpression> list){
        //if(subExpression.trim().isEmpty()) return;
        StoredVariablesExpression lastOne = list.getLast();
        String myOne = addExpression(lastOne.expression, subExpression);
        int resultOfLet = action(myOne, list);

        if(list.size() > 1){
            list.removeLast();
            lastOne = list.getLast();
            lastOne.expression = addExpression(lastOne.expression, ""+resultOfLet);
            if(lastOne.expression.startsWith("let")) lastOne.values = currentVars(lastOne.expression, list);
            list.set(list.size()-1, lastOne);
        } else{
            lastOne.expression = resultOfLet+"";
            list.set(list.size()-1, lastOne);
        }
    }
    private boolean isCommand(String expression){
        String trimmed = expression.trim();
        return trimmed.startsWith("let") || trimmed.startsWith("add") || trimmed.startsWith("mul");
    }
    private boolean isOpenClose(String expression, int start){
        return expression.charAt(start) == '(';
    }

    private Map<String,Integer> currentVars(String expression, List<StoredVariablesExpression> list){
        String[] expressions = expression.split(" ");
        Map<String,Integer> map = getMap(list);
        for(int i = 1; i<expressions.length-1; i+=2){
            String key = expressions[i];
            int value = map.containsKey(expressions[i+1])
                ? map.get(expressions[i+1]) 
                :Integer.parseInt(expressions[i+1]);
            map.put(key, value);
        }
        return map;
    }

    private int action(String expression, List<StoredVariablesExpression> list){
        String command = expression.substring(0,3);
        switch(command){
            case "let"->{return let(expression, list);}
            case "add"->{return add(expression, list);}
            case "mul"->{return mul(expression, list);}
        }
        return 0;
    }

    private int let(String expression, List<StoredVariablesExpression> list){
        String[] expressions = expression.split(" ");
        Map<String,Integer> map = currentVars(expression,list);
        
        int res = map.containsKey(expressions[expressions.length-1])
            ? map.get(expressions[expressions.length-1])  
            : Integer.parseInt(expressions[expressions.length-1]);
        return res;
    }

    private int add(String expression, List<StoredVariablesExpression> list){
        String[] expressions = expression.split(" ");
        Map<String,Integer> map = getMap(list);
        int p1 = map.containsKey(expressions[1])?map.get(expressions[1]) : Integer.parseInt(expressions[1]);
        int p2 = map.containsKey(expressions[2])?map.get(expressions[2]) : Integer.parseInt(expressions[2]);
        return p1 + p2;
    }

    private int mul(String expression, List<StoredVariablesExpression> list){
        String[] expressions = expression.split(" ");
        Map<String,Integer> map = getMap(list);
        int p1 = map.containsKey(expressions[1])?map.get(expressions[1]) : Integer.parseInt(expressions[1]);
        int p2 = map.containsKey(expressions[2])?map.get(expressions[2]) : Integer.parseInt(expressions[2]);
        return p1 * p2;
    }

    private Map<String,Integer> getMap(List<StoredVariablesExpression> list){
        return (list==null||list.isEmpty()||list.getLast().values==null) 
            ? new HashMap<>() 
            : new HashMap<>(list.getLast().values);
    }

    private String addExpression(String s1, String s2){
        s1 = s1.trim();
        s2 = s2.trim();
        return s1 + " " + s2;
    }

    class Solution{
        public int evaluate(String expression) {
            return eval(expression, new HashMap<>());
        }
        private int eval(String exp, Map<String, Integer> parent) {
            if (exp.charAt(0) != '(') {
                // just a number or a symbol
                if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-')
                    return Integer.parseInt(exp);
                return parent.get(exp);
            }
            // create a new scope, add add all the previous values to it
            Map<String, Integer> map = new HashMap<>();
            map.putAll(parent);
            List<String> tokens = parse(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length() - 1));
            if (exp.startsWith("(a")) { // add
                return eval(tokens.get(0), map) + eval(tokens.get(1), map);
            } else if (exp.startsWith("(m")) { // mult
                return eval(tokens.get(0), map) * eval(tokens.get(1), map);
            } else { // let
                for (int i = 0; i < tokens.size() - 2; i += 2)
                    map.put(tokens.get(i), eval(tokens.get(i + 1), map));
                return eval(tokens.get(tokens.size() - 1), map);
            }
        }
        private List<String> parse(String str) {
            // seperate the values between two parentheses
            List<String> res = new ArrayList<>();
            int par = 0;
            StringBuilder sb = new StringBuilder();
            for (char c: str.toCharArray()) {
                if (c == '(') par++;
                if (c == ')') par--;
                if (par == 0 && c == ' ') {
                    res.add(new String(sb));
                    sb = new StringBuilder();
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) res.add(new String(sb));
            return res;
        }
    }

    @Test
    public void test(){
        assertEquals(16, evaluate("(let foo 2 foo foo foo (let bar (let bar 4 foo 7 (add bar bar)) (mult foo bar)) foo foo foo)"));
        assertEquals(4, evaluate("(let x 3 y 2 x (add x y) y 4 y )"));
        assertEquals(144, evaluate("(let a (add 1 2) b (mult a 3) c 4 d (add a b) (mult d d))"));
        assertEquals(-2, evaluate("(let x -2 y x y)"));
        assertEquals(3, evaluate("(add 1 2)"));
        assertEquals(14, evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
        assertEquals(5, evaluate("(let x 1 y 2 x (add x y) (add x y))"));
        assertEquals(3, evaluate("(let x 3 y (let z 2 y 4 x) y)"));
        assertEquals(2, evaluate("(let x 3 y (let x 2 y (let z 2 y 3 z) x) y)"));
        assertEquals(2, evaluate("(let x 3 y (let x 2 y 4 x) y)"));
        assertEquals(2, evaluate("(let x 3 y 2 x 2 x)"));
        assertEquals(2, evaluate("(let x 3 y 2 x 2 y)"));
        assertEquals(3, evaluate("(let x 3 y 2 x)"));
        assertEquals(2, evaluate("(let x 3 x 2 x)"));
    }
}
