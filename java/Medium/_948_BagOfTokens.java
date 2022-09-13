package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _948_BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length-1,score = 0, points = 0;
        while(l<=r ){
            if(power >= tokens[l]){
                power -= tokens[l++];
                score = Math.max(score,++points);
            }else if(points > 0){
                points--;
                power += tokens[r--];
            }else{
                break;
            }
        }
        return score;
    }


    @Test
    public void test(){
        System.out.println(bagOfTokensScore(new int[]{100,200}, 150));
        System.out.println(bagOfTokensScore(new int[]{100,200,300,400}, 200));
        System.out.println(bagOfTokensScore(new int[]{100}, 50));
    }
}
