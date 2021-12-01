package Medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.testng.annotations.Test;

public class _1286_IteratorforCombination {
    class CombinationIterator {
        ArrayList<String> list = new ArrayList<>();
        int curIdx = 0;
        public CombinationIterator(String characters, int combinationLength) {
            list = getCases(characters.toCharArray(), combinationLength);
            Collections.sort(list);
        }
        
        public String next() {
            return list.get(curIdx++);
        }
        
        public boolean hasNext() {
            return curIdx < list.size();
        }

        private ArrayList<String> getCases(char[] arr, int length){
            ArrayList<String> res = new ArrayList<>();
            rec(res,"",arr,0,length);
            return res;
        }

        private void rec(ArrayList<String> res, String p, char[] arr, int start, int length){
            if(length == 0){
                res.add(p);
                return;
            }

            for(int i = start; i<arr.length; i++){
                rec(res,p+arr[i],arr,i+1,length-1);
            }
        }
    }

    @Test
    public void test(){
        
    }
}
