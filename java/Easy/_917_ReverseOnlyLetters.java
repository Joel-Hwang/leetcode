package Easy;

import org.testng.annotations.Test;

public class _917_ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] arC = s.toCharArray();
        for (int l = 0, r = arC.length - 1; l < r; l++, r--) {
            if( !(('A' <= arC[l] && arC[l] <= 'Z') || ('a' <= arC[l] && arC[l] <= 'z')) ){
                r++;
                continue;
            }
            if( !(('A' <= arC[r] && arC[r] <= 'Z') || ('a' <= arC[r] && arC[r] <= 'z')) ){
                l--;
                continue;
            }

            char temp = arC[l];
            arC[l] = arC[r];
            arC[r] = temp;
        }

        return new String(arC);
    }

    public String reverseOnlyLetters2(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j;) {
            if (!Character.isLetter(sb.charAt(i))) {
                ++i;
            } else if (!Character.isLetter(sb.charAt(j))) {
                --j;
            } else {
                sb.setCharAt(i, S.charAt(j));
                sb.setCharAt(j--, S.charAt(i++));
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
