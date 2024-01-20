package Easy;

import org.testng.annotations.Test;

public class _1025_DivisorGame {
    public boolean divisorGame(int n) {
        boolean[] map = new boolean[n+1];
        map[0] = false;
        map[1] = false;

        for(int i = 2; i<=n; i++){
            map[i]=false;
            for(int j = i/2; j>=1; j--){
                if(i%j != 0) continue;
                if(map[i-j]==false){
                    map[i]=true;
                    break;
                }
            }
        }
        return map[n];
    }

    @Test
    public void test(){
        System.out.println(divisorGame(2));
        System.out.println(divisorGame(3));
    }
}
