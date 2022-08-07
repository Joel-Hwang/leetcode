package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _1220_CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        int mod = (int)1e9 + 7;
        long[] vowels = new long[5];
        vowels[0] = 1;
        vowels[1] = 1;
        vowels[2] = 1;
        vowels[3] = 1;
        vowels[4] = 1;

        for(int idx = 1; idx<n; idx++) {
            long a = 0,e = 0,i = 0,o = 0,u = 0;
            e += vowels[0]%mod;

            a += vowels[1]%mod;
            i += vowels[1]%mod;
            
            a += vowels[2]%mod;
            e += vowels[2]%mod;
            o += vowels[2]%mod;
            u += vowels[2]%mod;
            
            i += vowels[3]%mod;
            u += vowels[3]%mod;

            a += vowels[4]%mod;

            vowels[0] = a;
            vowels[1] = e;
            vowels[2] = i;
            vowels[3] = o;
            vowels[4] = u;
        }
        return (int)((vowels[0]+vowels[1]+vowels[2]+vowels[3]+vowels[4])%mod);
    }

    @Test
    public void test(){
        assertEquals(68, countVowelPermutation(144));
        assertEquals(5, countVowelPermutation(1));
        assertEquals(10, countVowelPermutation(2));
        assertEquals(68, countVowelPermutation(5));
    }
}
