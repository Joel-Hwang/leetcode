package Easy;

import org.testng.annotations.Test;

public class _657_RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int ud = 0, lr = 0;
        for(int i = 0; i<moves.length(); i++){
            switch(moves.charAt(i)){
                case 'U' -> ud++;
                case 'D' -> ud--;
                case 'L' -> lr++;
                case 'R' -> lr--;
            }
        }
        return ud==0 && lr == 0;   
    }

    @Test
    public void test(){
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));
    }
}
