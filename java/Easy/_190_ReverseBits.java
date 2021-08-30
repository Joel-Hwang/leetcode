package Easy;

import org.testng.annotations.Test;

public class _190_ReverseBits {
    public int reverseBits(int n) {
        String b = Integer.toBinaryString(n);
        b = reverse(b);
        int n2 = Integer.parseUnsignedInt(b, 2);
        return n2;

    }

    private String reverse(String s){
        char[] arC = s.toCharArray();
        for(int i = 0; i<arC.length/2; i++){
            char temp = arC[i];
            arC[i] = arC[arC.length-1-i];
            arC[arC.length-1-i] = temp;
        }
        int right = 32-arC.length;
        String r = "";
        for(int i = 0; i<right; i++)
            r+="0";
        return new String(arC)+r;
    }

    @Test
    public void test(){
        System.out.println(reverseBits(-3));
        System.out.println(reverseBits(43261596));
    }
}
