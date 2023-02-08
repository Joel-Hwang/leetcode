package Hard;

import java.util.Stack;

import org.testng.annotations.Test;

public class _839_SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        boolean map[][] = new boolean[strs.length][strs.length];
        int[] group = new int[strs.length];
        int curGroup = 1;
        for(int i = 0; i<strs.length-1; i++)
            for(int j = i+1; j<strs.length; j++)
                if(isSimilar(strs[i], strs[j])){
                    map[i][j] = true;
                    map[j][i] = true;
                }
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i<strs.length; i++){
            if(group[i] == 0){
                group[i] = curGroup;
                curGroup++;
            }
            stk.add(i);

            while(!stk.isEmpty()){
                int curIdx = stk.pop();
                for(int j=0; j<strs.length; j++){
                    if(map[curIdx][j] && group[j] == 0){
                        group[j] = group[curIdx];
                        stk.add(j);
                    }    
                }
            }
        }

        return curGroup-1;
    }

    private boolean isSimilar(String a, String b){
        if(a.length() != b.length()) return false;
        int[] arA = new int[26];
        int[] arB = new int[26];
        int diffCnt = 0;
        for(int i = 0; i<a.length(); i++){
            arA[a.charAt(i)-'a']++;
            arB[b.charAt(i)-'a']++;
            if(a.charAt(i) != b.charAt(i)) diffCnt++;
            if(diffCnt > 2) return false;
        }

        for(int i = 0; i<arA.length; i++)
            if(arA[i]!=arB[i]) return false;
        return true;
    }

    @Test
    public void test(){
        System.out.println(numSimilarGroups(new String[]{"omv","ovm"}));
        System.out.println(numSimilarGroups(new String[]{"tars","rats","arts","star"}));
    }
}
