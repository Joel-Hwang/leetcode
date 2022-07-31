package Medium;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.testng.annotations.Test;

public class _1734_DecodeXORedPermutation {
    public int[] decode(int[] encoded) {
        int[] res = new int[encoded.length + 1];
        for(int i = 1; i<encoded.length; i+=2){
            res[0] ^= i;
            res[0] ^= i+1;
            res[0] ^= encoded[i];
        }
        res[0] ^= encoded.length+1;

        for (int i = 0; i < encoded.length; i++) {
            res[i + 1] = res[i] ^ encoded[i];
        }
        return res;
    }

    

    public int[] decode2(int[] encoded) {
        // lets say we have [a,b,c,d,e] as actual array
        // step 1: so encoded array would become --> [a^b, b^c, c^d, d^e]
        // step 2 : do XOR for even ones from step 1 above we will get --> b^c^d^e (if
        // we take even ones)
        // step 3 : we know we have 1 to n do XOR for all of them (a to e --> a^b^c^d^e)
        // finally we can calculate : 'a = step2 ^ step 3' --> (b^c^d^e)^(a^b^c^d^e) ==
        // a (since b^b = 0, similarly c,d,e also cancel out leaving 'a' behind)
        int ans = 0;
        for (int i = 0; i < encoded.length; i++) {
            ans ^= i + 1; // doing XOR for all of them
            if (i % 2 == 1) {
                ans ^= encoded[i]; // doing xor for even ones
            }
        }
        ans ^= encoded.length + 1;

        int[] result = new int[encoded.length + 1];
        result[0] = ans;
        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = result[i] ^ encoded[i]; // if a^b = c --> a^c = b (property of XOR)
        }
        return result;

    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1,2,3}, decode(new int[]{3,1}));
        assertArrayEquals(new int[]{1,2,3}, decode(new int[]{3,1}));
    }
}
