package Medium;

import org.testng.annotations.Test;

public class _1963_MinimumNumberOfSwapsToMakeTheStringBalanced {
    public int minSwaps(String s) {
        int result = 0;
        int cur = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)==']'){
                cur--;
                if(cur<0){
                    result++;
                    cur+=2;
                }
            }else{ //s.charAt(i)=='['
                cur++;
            }
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(minSwaps("[[[]]]][][]][[]]][[["));
        System.out.println(minSwaps("]][[]]][[["));
        System.out.println(minSwaps("][]["));
        System.out.println(minSwaps("]]][[["));
        System.out.println(minSwaps("[]"));
        System.out.println(minSwaps("]]]]][[[[["));
        System.out.println(minSwaps("][][][][]["));
    }
}

/*

[ 1
[ 2
[ 3
] 2
] 1
] 0
] -1   -> 1
[ 2
] 1
[ 2
] 1
] 0
[ 1
[ 2
] 1
] 0
] -1 -> 1
[ 2
[ 3
[ 4


*/