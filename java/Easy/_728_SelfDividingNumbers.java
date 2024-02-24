package Easy;

import java.util.*;

import org.testng.annotations.Test;
public class _728_SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left; i<=right; i++){
            if(isSelfDivingNumber(i))
                res.add(i);
        }
        return res;
    }

    private boolean isSelfDivingNumber(int n){
        int originalN = n;
        while(n>0){
            int remain = n%10;
            if(remain == 0)
                return false;
            if(originalN % remain != 0) 
                return false;

            n /= 10;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(selfDividingNumbers(1, 22));
    }
}
