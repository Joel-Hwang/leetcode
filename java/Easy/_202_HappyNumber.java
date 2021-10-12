package Easy;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class _202_HappyNumber{
    public boolean isHappy(int n) {
        if(n==1) return true;

        Set<Integer> inLoop = new HashSet();
        //square digits and sum
        while(n>3){
            int curSum = 0;
            //divide each digits
            while(n>0){
                int digit = n%10;
                n /= 10;
                curSum += (digit*digit);
            }
            if(inLoop.contains(curSum)) return false;
            inLoop.add(curSum);
            if(curSum == 1) return true;
            n = curSum;
            
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(isHappy(4));
        System.out.println(isHappy(2));
        System.out.println(isHappy(19));
    }
}