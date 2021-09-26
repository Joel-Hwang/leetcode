package Easy;

import org.testng.annotations.Test;

public class _482_LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-", "");
        if("".equals(s)) return "";
        StringBuilder sb = new StringBuilder();
        int start = s.length()%k;
        if(start != 0) sb.append("-"+s.substring(0, start));
        for(int i = start; i<s.length(); i+=k){
            sb.append("-");
            sb.append(s.substring(i, i+k));
        }
        
        return sb.toString().substring(1).toUpperCase();
    }

    @Test
    public void test(){
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
