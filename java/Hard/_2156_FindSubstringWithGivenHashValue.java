package Hard;

import org.testng.annotations.Test;

public class _2156_FindSubstringWithGivenHashValue {
    public String subStrHash(String s, int p, int m, int k, int hashValue) {
        long cur = 0, pk = 1;
        int res = 0, n = s.length();
        for(int i = n-1; i>=0; i--){
            cur = (cur*p + s.charAt(i)-'a'+1)%m;
            if( i+k >= n) pk = pk*p%m;
            else
                cur = (cur - (s.charAt(i+k) - 'a' + 1)*pk%m + m)%m;
            if(cur == hashValue) res = i;
        }
        
        return s.substring(res, res+k);
    }

    @Test
    public void test(){
        System.out.println(subStrHash("xqgfatvtlwnnkxipmipcpqwbxihxblaplpfckvxtihonijhtezdnkjmmk", 22, 51, 41, 9));
        System.out.println(subStrHash("leetcode", 7, 20, 2, 0));
        System.out.println(subStrHash("fbxzaad", 31, 100, 3, 32));
    }
}
