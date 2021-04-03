import Medium.*;

import java.util.*;

import CS.LinkedListNode;
import CS.Node;
import Easy.*;
import Hard.*;

public class Main {
    public static void main(String[] args) {
        //new _378_Kth_Smallest_Element_Sorted_Matrix();
        letterCombinations("23");
    }

    public static List<String> letterCombinations(String digits) {
        if("".equals(digits)) return null;
        LinkedList<String> queue = new LinkedList<>();
        String[] matrix = {"","","abc","def","ghi","jkl","mno","qprs","tuv","wxyz"};
        char[] ardigit = digits.toCharArray();
        queue.add("");
        for(int j = 0; j<ardigit.length;j++){
            char c = ardigit[j];
            String m = matrix[c-'0'];
            while(queue.getFirst().length() == j){
                String q = queue.removeFirst();
                for(int i=0; i<m.length(); i++){
                    queue.add(q+m.substring(i, i+1));
                }
            }
        }
        return queue;
    }

}