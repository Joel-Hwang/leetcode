package Easy;

import org.testng.annotations.Test;

public class _1528_ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        for(int i = 0; i<indices.length; i++)
            res[indices[i]] = s.charAt(i);
        return new String(res);
    }

    @Test
    public void test(){
        System.out.println(restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
    }
}
