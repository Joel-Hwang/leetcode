package Medium;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int[] ver1 = pureVersion(version1);
        int[] ver2 = pureVersion(version2);
        for(int i = 0; i<Math.max(ver1.length, ver2.length); i++){
            int elemVer1 = i<ver1.length?ver1[i]:0;
            int elemVer2 = i<ver2.length?ver2[i]:0;
            if(elemVer1 > elemVer2) return 1;
            else if(elemVer1 < elemVer2) return -1;
            else continue;
        }
        return 0;
    }

    private int[] pureVersion(String version){

        String[] arV = version.split("\\.");
        int[] res = new int[arV.length];
        for(int i = 0; i<arV.length; i++){
            int j = 0;
            while(j < arV[i].length() && arV[i].charAt(j) == '0') j++;
            StringBuilder sb = new StringBuilder(arV[i].substring(j));
            if(sb.length() == 0) sb.append("0");
            res[i] = Integer.parseInt(sb.toString());
        }
        return res;
    }

    @Test
    public void test(){
        assertEquals(0, compareVersion("1.01", "1.001"));
        assertEquals(0, compareVersion("1.0", "1.0.0"));
        assertEquals(-1, compareVersion("0.1", "1.1"));


        assertArrayEquals(new int[]{1,0,0,0}, pureVersion("0001.0.0.0"));
        assertArrayEquals(new int[]{1,1}, pureVersion("1.01"));
        assertArrayEquals(new int[]{1,1}, pureVersion("1.001"));
        assertArrayEquals(new int[]{1,0}, pureVersion("1.0"));
        assertArrayEquals(new int[]{1,0,0}, pureVersion("1.0.0"));
        assertArrayEquals(new int[]{0,1}, pureVersion("0.1"));
        assertArrayEquals(new int[]{1,1}, pureVersion("1.1"));
    }
}
