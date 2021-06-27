package Easy;

import org.testng.annotations.Test;

public class _69_Sqrt {
    public int mySqrt(int x) {
        if(x<2) return x;
        long l = 0, r = x;
        long m;
        while(l<r){
            m = (l+r)/2;
            if(m*m<=x && x<(m+1)*(m+1) ) return (int)m;
            else if(m*m>x){
                r = m;
            }else{
                l = m;
            }
        }

        return x;
    }

    public int mySqrt2(int x) {
        if(x == 0) return 0;
        else if(x == 1)return 1;
        
        int left = 0, right = x, mid = (right-left)/2;
        
        while(left <= right){
            if(mid == (x/mid)) return mid;
            else if(mid < (x/mid)) left = mid + 1;
            else if(mid > (x/mid)) right = mid - 1;
            
            mid = left + (right-left)/2;
        }
        
        return right;
    }
    @Test
    public void test(){
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(6));
        System.out.println(mySqrt(7));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));
        
        
    }
}
