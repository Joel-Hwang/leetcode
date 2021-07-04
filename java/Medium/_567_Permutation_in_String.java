package Medium;

import java.util.Arrays;

public class _567_Permutation_in_String {
    /*
    
    Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 
"ab"
"eidboaoo"
    */
    public _567_Permutation_in_String(){
        System.out.println(checkInclusion("ab","eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        Arrays.sort(cs1);
        s1 = new String(cs1);

        for(int i = 0; i<=s2.length()-s1.length(); i++){
            String tempS2 = s2.substring(i, i+s1.length());
            char[] cs2 = tempS2.toCharArray();
            Arrays.sort(cs2);
            tempS2 = new String(cs2);
            if(tempS2.equals(s1)) return true;
        }
        return false;
    }

   
}
