package zContest;

import java.util.Arrays;
import java.util.Comparator;

import org.testng.annotations.Test;

public class _5855_FindtheKthLargestIntegerintheArray {
    public String kthLargestNumber(String[] nums, int k) {
         
        Arrays.sort(nums, new Comparator<String>(){
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) return 1;
                else if (o1.length() < o2.length()) return -1;
                else{
                    int i = 0;
                    while(i<o1.length()){
                        char c1 = o1.charAt(i);
                        char c2 = o2.charAt(i++);
                        if(c1 > c2) return 1;
                        else if(c1 < c2) return -1;
                    }
                    return 0;
                }
            };

        });

        return nums[nums.length-k];
    }

    

    @Test
    public void test(){
        System.out.println(kthLargestNumber(new String[]{"0","0"} , 2));
        System.out.println(kthLargestNumber(new String[]{"3","6","7","10"} , 4));
    }
}
