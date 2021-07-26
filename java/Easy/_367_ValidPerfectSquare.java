package Easy;

import org.testng.annotations.Test;

public class _367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num == 1 || num == 4 || num == 9) return true;
        int l = 1, r = num/2;
        while(l<r){
            long m = (l+r)/2;
            if(m*m == num) return true;
            else if(m*m>num) r = (int)m;
            else l = (int)m+1;
        }   
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        if(num == 1) return true;
        int power2 = 0;
        for(int i = 1; i<=num/2; i++){
            if(i*i < power2) return false;
            power2 = i*i;
            if(num == power2) return true;
            if(i*i > num) return false;
        }

        return false;
    }

    @Test
    public void test(){
        System.out.println(isPerfectSquare(808201));
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(2147483647));
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(16));
    }
}
