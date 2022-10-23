package Easy;

import org.testng.annotations.Test;

public class _1047_RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
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
        removeDuplicates("abbaca");
        removeDuplicates("azxxzy");
    }
}
