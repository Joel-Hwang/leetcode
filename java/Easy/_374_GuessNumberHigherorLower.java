package Easy;

import org.testng.annotations.Test;

public class _374_GuessNumberHigherorLower {
    public int guessNumber(int n) {
        long l = 1, r = n;
        int cnt = 0;
        while(l<r){
            cnt++;
            int m = (int)((l+r)/2);
            int comp = guess(m);
            if(comp>0){
                l = m+1;
            }else if(comp<0){
                r = m;
            }else{
                return m;
            }
        }
        System.out.println(cnt);
        return (int)l;
    }


    public int guess(int n){
        int res = 1702766719;
        if(res>n) return 1;
        if(res<n) return -1;
        return 0;
    }


    @Test
    public void test(){
        System.out.println(guessNumber(2126753390));
    }
}
