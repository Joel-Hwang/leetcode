package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _93_RestoreIPAddresses {
    public _93_RestoreIPAddresses(){
        restoreIpAddresses("101023");
    }


    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if(s.length()>12 || s.length()<4) return res;


        for(int i = 1; i<=3; i++){
            String a = s.substring(0, i);
            if(isAdr(a)){
                for(int j = i+1; j<=i+3; j++){
                    if(j > s.length()) break;
                    String b = s.substring(i,j);
                    if(isAdr(b)){
                        for(int k = j+1; k<=j+3; k++){
                            if(k > s.length()) break;
                            String c = s.substring(j, k);
                            if(isAdr(c)){
                                if(k > s.length()) break;
                                String d = s.substring(k);
                                if(isAdr(d))
                                    res.add(a+"."+b+"."+c+"."+d);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    


    private boolean isAdr(String s){
        if(s.length()>1 && s.startsWith("0")) return false;
        if("".equals(s) || Integer.parseInt(s)>255) return false;
        return true;
    }


    /*DFS*/
    public List<String> restoreIpAddresses2(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }
    
    private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) solutions.add(restored);
        
        for (int i=1; i<4; i++) {
            if (idx+i > ip.length()) break;
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
            restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
        }
    }

}
