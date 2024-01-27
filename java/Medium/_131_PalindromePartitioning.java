package Medium;
import java.util.*;

import org.testng.annotations.Test;

public class _131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        for(int i = 1; i<=s.length(); i++){
            String sub = s.substring(0,i);
            if(isPalindrome(sub)==false) 
                continue;
            List<List<String>> children = partition(s.substring(sub.length()));
            if(children.size() == 0){
                List<String> row = new ArrayList<>();
                row.add(sub);
                result.add(row);
                return result;
            }

            for(int j = 0; j<children.size(); j++)
                children.get(j).add(0, sub);

            result.addAll(children);     
        }
        return result;
    }


    private boolean isPalindrome(String s){
        for(int i = 0; i<s.length()/2; i++)
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }

    @Test
    public void test(){
        List<List<String>> res = partition("cdd");
        for(List<String> row : res){
            for(String col : row)
                System.out.print(col+", ");
            System.out.println();
        }
    }
}
