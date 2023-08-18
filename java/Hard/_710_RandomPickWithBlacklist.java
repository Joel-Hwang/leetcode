package Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class _710_RandomPickWithBlacklist {
    class Solution {
        Random random;
        Set<Integer> blackSet;
        int n=0;
        int[] whitelist = new int[0];

        public Solution(int n, int[] blacklist) {
            this.n = n;
            random =  new Random();
            if(blacklist.length > 0.9*n)
                whitelist = getWhiteList(n,blacklist);
            else
                blackSet = getBlackSet(blacklist);
        }

        private Set<Integer> getBlackSet(int[] blacklist){
            Set<Integer> blackSet = new HashSet<>();
            for(int blackNumber : blacklist )
                blackSet.add(blackNumber);
            return blackSet;
        }
        
        private int[] getWhiteList(int n, int[] blacklist){
            int[] whitelist = new int[n-blacklist.length];
            Arrays.sort(blacklist);
            int idxBlackList = 0;
            int idxWhiteList = 0;
            for(int i = 0; i<n; i++){
                if(idxBlackList < blacklist.length && i == blacklist[idxBlackList]){
                    idxBlackList++;
                    continue;
                }
                whitelist[idxWhiteList++] = i;
            }
            return whitelist;
        }
    
        public int pick() {
            return whitelist.length==0?pickFromBlackList():pickFromWhiteList();
        }

        private int pickFromWhiteList(){
            int randomValue = whitelist[random.nextInt(whitelist.length)];
            return randomValue;
        }
        private int pickFromBlackList(){
            int randomValue = 0;
            do{
                randomValue = random.nextInt(n);
            }while( blackSet.contains(randomValue) );
            return randomValue;
        }
    }
}
