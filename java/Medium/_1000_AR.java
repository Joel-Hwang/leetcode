package Medium;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _1000_AR {
    public int ar(String ar){
        List<Integer> list = new ArrayList<>();
        int sign = 1;
        int cursor = 0;
        for(char c : ar.toCharArray()){
            switch(c){
                case 'A' ->{
                    if(list.size() <= cursor){
                        list.add(1);
                    }else{
                        list.set(cursor, list.get(cursor)+sign);
                    }
                    cursor++;
                }
                case 'R' ->{
                    sign *= -1;
                    cursor = 0;
                }
            }
        }
        int res = 0;
        for(int i=0; i<list.size(); i++){
            res += Math.pow(2, i)*list.get(i);
        }
        return res;
    }

    @Test
    public void test(){
        Assert.assertEquals(19, ar("AAAARAARAAA"));
    }
}
