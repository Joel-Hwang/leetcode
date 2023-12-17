package Medium;

import org.testng.annotations.Test;

public class _1754_LargestMergeOfTwoStrings {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int point1 = 0, point2 = 0;
        while(point1 < word1.length() || point2 < word2.length()){
            if(isWord1Better(word1, word2, point1, point2)){
                sb.append(word1.charAt(point1++));
            }else{
                sb.append(word2.charAt(point2++));
            }
        }
        return sb.toString();
    }

    private boolean isWord1Better(String word1, String word2, int point1, int point2){
        if(point1 >= word1.length()) return false;
        if(point2 >= word2.length()) return true;

        while(point1 < word1.length() && point2 < word2.length()){
            if(word1.charAt(point1) == word2.charAt(point2)){
                point1++;
                point2++;    
            }else{
                return word1.charAt(point1) > word2.charAt(point2);
            }
        }
        return word1.length()-point1 > word2.length()-point2 ;
    }


    public String largestMerge2(String s1, String s2) {
        if (s1.length() == 0  || s2.length() == 0)
            return s1 + s2;
        if (s1.compareTo(s2) > 0)
            return s1.charAt(0) + largestMerge(s1.substring(1), s2);
        return s2.charAt(0) + largestMerge(s1, s2.substring(1));
    }

    @Test
    public void test(){
        //eenpnn
        //ee
        //eenpnnee
        //eeeenpnn

        System.out.println(largestMerge("nnnnpnnennenpnnnnneenpnn", "nnnennnnnnpnnennnnennnnee"));
        System.out.println(largestMerge("cabaa", "bcaaa"));
    }
}
