package Easy;
import java.util.Arrays;

public class LongestCommonPrefix {
    public LongestCommonPrefix(){
        String[] strs = {"dog","racecar","car"};
        longestCommonPrefix(strs);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        Arrays.sort(strs);

        for(int i = 0; i<strs[0].length(); i++){
            if( strs[strs.length-1].indexOf(strs[0].substring(0, i+1)) != 0 ){
                return strs[0].substring(0,i==0?0:i);
            }
        }
    
        return strs[0];
    }
}


/*

20%        
if(strs.length == 0) return "";
        String result = "";
        for(int i = 0; i<strs[0].length(); i++){
            char cur = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(strs[j].length()<=i || strs[j].charAt(i) != cur){
                    return result;
                }
            }
            result += cur;
        }
        return result;

100%
if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);             
        }
    }
    return strs[0];

100%
if(strs == null || strs.length == 0)    return "";
    String pre = strs[0];
    int i = 1;
    while(i < strs.length){
        while(strs[i].indexOf(pre) != 0)
            pre = pre.substring(0,pre.length()-1);
        i++;
    }
    return pre;

*/