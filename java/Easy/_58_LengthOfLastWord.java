package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _58_LengthOfLastWord{

    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] spl = s.split(" ");
    
        return spl[spl.length-1].length();
    }

    @Test
    public void test(){
        assertEquals(lengthOfLastWord("Hello World"), 5);
    }
}