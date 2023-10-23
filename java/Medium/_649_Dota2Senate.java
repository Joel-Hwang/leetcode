package Medium;

import org.testng.annotations.Test;

public class _649_Dota2Senate {
    public String predictPartyVictory(String senate) {
        int countR=0, countD=0, skipR=0, skipD=0;
        char[] arSenate = senate.toCharArray();
        for(char senator : arSenate)
            if(senator == 'R') countR++; else countD++;
        
        int index = -1;
        while(countD>0 && countR > 0){
            index = (index+1)%arSenate.length;
            if(arSenate[index]=='R'){
                if(skipR>0){
                    arSenate[index] = '0';
                    skipR--;
                    continue;
                }
                countD--;
                skipD++;
            }else if(arSenate[index]=='D'){
                if(skipD>0){
                    arSenate[index]='0';
                    skipD--;
                    continue;
                }
                countR--;
                skipR++;
            }else{
                continue;
            }
        }
        
        return countD>0?"Dire":"Radiant";
    }

  

    @Test
    public void test(){
        System.out.println(predictPartyVictory("DRRD"));
        System.out.println(predictPartyVictory("DRDRR"));
        System.out.println(predictPartyVictory("RD"));
        System.out.println(predictPartyVictory("RDD"));
        System.out.println(predictPartyVictory("RRDDD"));
    }
}
