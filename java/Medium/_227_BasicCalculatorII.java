package Medium;

import java.util.ArrayList;


import org.testng.annotations.Test;

public class _227_BasicCalculatorII {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        s = s.startsWith("-")?s:"+"+s;
        ArrayList<String> elems = new ArrayList<>();
        ArrayList<Integer> preferList = new ArrayList<>();
        int start = 0;
        int res = 0;
        for(int i = 1; i<s.length(); i++){
            String curVal = String.valueOf(s.charAt(i));
            if( "+-*/".contains( curVal ) ){
                elems.add(s.substring(start, i));
                start = i;
                if( "*/".contains( curVal ) ) preferList.add(elems.size());
            }
        }  
        elems.add(s.substring(start, s.length()));

        int cnt = 0;
        for(int i : preferList){
            i = i-cnt;
            int elem1 = Integer.parseInt(elems.get(i-1).substring(1));
            int elem2 = Integer.parseInt(elems.get(i).substring(1));
            char op = elems.get(i).charAt(0);
            int tempRes = op == '*'?elem1*elem2:elem1/elem2;
            elems.set(i-1, ""+elems.get(i-1).charAt(0)+tempRes);
            
            elems.remove(i);
            cnt++;
        }
        
        res = Integer.parseInt(elems.get(0));
        for(int i = 1; i<elems.size(); i++){
            int elem = Integer.parseInt(elems.get(i).substring(1));
            char op = elems.get(i).charAt(0);
            res = op=='+'?res+elem:res-elem;
        }
        return res;
    }


    @Test
    public void test(){
        System.out.println(calculate("2*3*4"));
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate("3/2"));
        System.out.println(calculate("3+5/2"));
    }
}
