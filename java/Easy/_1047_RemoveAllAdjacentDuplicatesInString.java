package Easy;

import org.testng.annotations.Test;

public class _1047_RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        char[] arC = s.toCharArray();
        int i = 0;
        for(int j = 0; j<arC.length; j++, i++){
            arC[i] = arC[j];
            if(i>0 && arC[i]==arC[i-1]) i-=2;
        }
        return new String(arC,0,i);
        
    }

    public String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i<sb.length()-1; i++) {
            if(sb.charAt(i) == sb.charAt(i+1)){
                sb.delete(i, i+2);
                i = Math.max(i-2,-1);
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        removeDuplicates("azxxxzy");
        removeDuplicates("abbaca");
    }
}
