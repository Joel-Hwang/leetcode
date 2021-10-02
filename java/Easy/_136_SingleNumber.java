package Easy;

import java.util.HashSet;
import java.util.Set;

public class _136_SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet();
        for(int n : nums){
            if(set.contains(n))
                res -= n;
            else{
                res+=n;
                set.add(n);
            }
        }
        return res;
    }


    //숫자 두개가 똑같으면 xor 했을 때 0이 나옴
    //xor은 둘 다 00이거나 11일때 0, 01이거나 10일때 1
    public int singleNumber2(int A[]) {
        int result = 0;
        for (int i = 0; i<A.length; i++)
        {
		    result ^=A[i];
        }
	    return result;
    } 
}
