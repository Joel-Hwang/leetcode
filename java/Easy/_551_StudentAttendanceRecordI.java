package Easy;

import org.testng.annotations.Test;

public class _551_StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int lateCnt = 0;
        int absCnt = 0;
        for(char c : s.toCharArray()){
            if(c == 'L') lateCnt++;
            if(c == 'A') absCnt++;
            if(c == 'A' || c == 'P') lateCnt = 0;
            if(absCnt>1 || lateCnt>2) return false; 

        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
    }
}
