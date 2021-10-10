package Medium;

import org.testng.annotations.Test;

public class _151_ReverseWordsinaString {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length-1; i>=0; i--){
            if(words[i].length()>0)
                sb.append(" "+words[i]);
        }
        return sb.toString().substring(1);
    }

    @Test
    public void test(){
        System.out.println(reverseWords("a good   example"));
    }
}
