package Easy;

public class _28_Strstr {
    public _28_Strstr(){
        strStr2("hello","ll");
    }

    public int strStr(String haystack, String needle) {
        if("".equals(needle)) return 0;
        char[] arHayStack = haystack.toCharArray();
        char[] arNeedle = needle.toCharArray();
        for(int i = 0; i< arHayStack.length - arNeedle.length +1; i++){
            if(arNeedle[0] == arHayStack[i]){
                boolean isIn = true;
                for(int j = 1; j<arNeedle.length; j++){
                    if(arNeedle[j] != arHayStack[i+j]){
                        isIn = false;
                        break;
                    }
                }
                if(isIn) return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
              //j가 needle의 길이가 된다는건 break 없었다는 거니까 포함된다는 뜻
              if (j == needle.length()) return i;
              //끝까지 봤는데도 없는 경우 
              if (i + j == haystack.length()) return -1;
              //같다고 가정하고 다르면 break;
              if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
