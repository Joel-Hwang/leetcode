package Medium;

import org.testng.annotations.Test;

public class _1813_SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        if(words2.length > words1.length) return areSentencesSimilar(sentence2, sentence1);


        for(int left = 0; left <= words2.length; left++){
            int right = words2.length-left;

            boolean matched = true;
            for(int i = 0; i<left; i++){
                if(!words2[i].equals(words1[i])){
                    matched = false;
                    break;
                }
            }
            for(int i = 0; i<right; i++){
                if( !words2[words2.length-1-i].equals(words1[words1.length-1-i]) ){
                    matched = false;
                    break;
                }
            }
            if(matched) return true;
        }

        return false;
    }

    @Test
    public void test(){
        System.out.println(areSentencesSimilar("Eating right now", "Eating"));
        System.out.println(areSentencesSimilar("of", "A lot of words"));
        System.out.println(areSentencesSimilar("B", "ByI BMyQIqce b bARkkMaABi vlR RLHhqjNzCN oXvyK zRXR q ff B yHS OD KkvJA P JdWksnH"));
        System.out.println(areSentencesSimilar("My name is Haley", "My Haley"));
    }
}
