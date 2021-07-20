package Easy;

import org.testng.annotations.Test;

public class _383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] rs = ransomNote.toCharArray();
        char[] mgz = magazine.toCharArray();
        int cnt = 0;
        for(int i = 0; i<rs.length; i++){
            for(int j = 0; j<mgz.length; j++){
                if(mgz[j] == rs[i]){
                    cnt++;
                    mgz[j] = ' ';
                    break;
                }
            }
        }
        
        return cnt == rs.length;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] c = new int[26];
        char[] rs = ransomNote.toCharArray();
        char[] mgz = magazine.toCharArray();
        for(char r : mgz){
            c[r-'a']++;
        }

        for(int i = 0; i<rs.length; i++){
            if(--c[rs[i]-'a'] < 0) return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(canConstruct2("aa", "aab"));
    }
}
