package Easy;

import org.testng.annotations.Test;

public class _1629_SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int longIdx = 0;
        int longDur = releaseTimes[0];
        for(int i = 1; i<releaseTimes.length; i++){
            int dur = releaseTimes[i] - releaseTimes[i-1];
            if(dur > longDur || 
            (dur == longDur && keysPressed.charAt(i) > keysPressed.charAt(longIdx) )){
                longIdx = i;
                longDur = dur;
            }
        }

        return keysPressed.charAt(longIdx);
    }

    @Test
    public void test(){
        System.out.println(slowestKey(new int[]{12,23,36,46,62}, "spuda"));
        System.out.println(slowestKey(new int[]{9,29,49,50}, "cbcd"));
    }
}
