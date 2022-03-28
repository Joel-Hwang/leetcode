package Medium;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.*;

import org.testng.annotations.Test;

public class _412_FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        for(int i = 1; i<=n; i++){
            boolean div3 = i%3 == 0;
            boolean div5 = i%5 == 0;
            if(div3 && div5) res.add("FizzBuzz");
            else if(div3) res.add("Fizz");
            else if(div5) res.add("Buzz");
            else res.add(String.valueOf(i));
        }
        return res;
    }

    @Test
    public void test(){
        assertArrayEquals(new String[]{"1","2","Fizz"}, fizzBuzz(3).toArray());
    }
}
