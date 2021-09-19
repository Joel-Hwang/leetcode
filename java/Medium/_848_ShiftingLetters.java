package Medium;

import org.testng.annotations.Test;

public class _848_ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = shifts[i] % 26 + shifts[i + 1] % 26;
        }
        char[] arC = s.toCharArray();
        for(int i = 0; i<shifts.length; i++){
            arC[i] = (char)((arC[i]+shifts[i]-'a')%26+'a');
        }
        return new String(arC);
    }

    @Test
    public void test(){
        System.out.println(shiftingLetters("aaa", new int[]{1,2,3}));
    }

}
