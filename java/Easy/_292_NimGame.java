package Easy;

import org.testng.annotations.Test;

public class _292_NimGame {
    public boolean canWinNim(int n) {
        return 1<= n%4 && n%4 <=3;
    }

    @Test
    public void test(){
        System.out.println(canWinNim(1));
    }
}
