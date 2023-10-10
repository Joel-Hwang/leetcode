package Medium;

import java.util.ArrayList;
import java.util.List;

public class _2222_NumberOfWaysToSelectBuildings{
    public long numberOfWays(String s) {

        long res = 0, one=0,zero=0,oneZero=0,zeroOne=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                zero++;
                oneZero += one;
                res += zeroOne;
            }else{
                one++;
                zeroOne += zero;
                res += oneZero;
            }
        }

        return res;
    }
}