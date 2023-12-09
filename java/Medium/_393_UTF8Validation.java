package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _393_UTF8Validation {
    public boolean validUtf8(int[] data) {
        int start = 0;
        while(start<data.length){
            int validUtf8Bytes = getValidUtf8Bytes(start, data);
            if(validUtf8Bytes<0) return false;
            if(validUtf8Bytes == 0){ start++; continue;}
            start += validUtf8Bytes;
        }

        //그 뒤에 숫자 더 있으면 0으로 시작한느지 검사
        for(int i = start; i<data.length; i++){
            String binary = toBinaryString(data[i]);
            if(binary.charAt(0)!='0')
                return false;
        }
        
        return true;
    }

    private int getValidUtf8Bytes(int start, int[] data){
        //처음 숫자 1이 몇개인지 검사
        int countOfOne = getCountOfOne(data[start]);
        if(countOfOne == 1) return -1;
        if(countOfOne > 4) return -1;
        if(countOfOne > data.length-start) return -1;
        for(int i = start+1; i<start+countOfOne; i++){
            String binary = toBinaryString(data[i]);
            if(binary.charAt(0)!='1' || binary.charAt(1)!='0') 
                return -1;
        }
        
        return countOfOne;
    }

    private int getCountOfOne(int num){
        String binary = toBinaryString(num);
        int countOfOne = 0;
        for(char c:binary.toCharArray()){
            if(c=='1') countOfOne++;
            else break;
        }
        return countOfOne;
    }

    private String toBinaryString(int num){
        String bString = Integer.toBinaryString(num);
        int padding = 8-bString.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<padding; i++) sb.append("0");
        
        return sb.append(bString).toString();
    }

    @Test
    public void test(){
        assertEquals(true, validUtf8(new int[]{115,100,102,231,154,132,13,10}));
        assertEquals(true, validUtf8(new int[]{197,130,1}));
        assertEquals(false, validUtf8(new int[]{235,140,4}));
        assertEquals(false, validUtf8(new int[]{235}));
        assertEquals(false, validUtf8(new int[]{145}));
        assertEquals(true, validUtf8(new int[]{228,189,160,229,165,189,13,10}));
    }
}
