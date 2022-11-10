package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class 옹알이2 {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String babble : babbling)
            if(canSay(babble)) answer++;
        return answer;
    }
    
    private boolean canSay(String babble){
        String[] list = {"aya", "ye", "woo", "ma" };
        for(String l : list){
            if(babble.contains(l+l)) return false;
            babble = babble.replace(l," ");
        }
        
        return "".equals(babble.trim());
    }

    @Test
    public void test(){
        assertEquals(2, solution(new String[]{"ayawooaya","yemayemayema"}));
        assertEquals(0, solution(new String[]{"yayae"}));
        assertEquals(2, solution(new String[]{"ayayewooma", "yeayawoowoo", "woo", "maa"}));
        assertEquals(3, solution(new String[]{"aya", "ye", "woo", "maa"}));
        assertEquals(4, solution(new String[]{"aya", "ye", "woo", "ma"}));
        assertEquals(1, solution(new String[]{"aya", "yee", "u", "maa"}));
        assertEquals(2, solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
}
