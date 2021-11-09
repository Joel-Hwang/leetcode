package Easy;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for(int i = 0, j=0; i<g.length && j<s.length;){
            if(s[j] >= g[i]){
                res++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(findContentChildren(new int[]{5,5}, new int[]{1,10}));
        System.out.println(findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
