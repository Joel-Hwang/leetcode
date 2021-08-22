package zContest;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _5851_FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        int prev = Integer.parseInt(nums[0],2);
        if(prev != 0) return cntr(nums[0].length(),"0");

        for(int i = 1; i<nums.length; i++){
            int a = Integer.parseInt(nums[i],2);
            if(a - prev > 1) return cntr2(nums[0].length(),Integer.toBinaryString(prev+1));
            prev = a;
        }
        return cntr(nums[0].length(),"1");
    }

    public String cntr(int cnt, String a){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<cnt; i++)
            sb.append(a);
        return sb.toString();
    }

    public String cntr2(int cnt, String a){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<cnt-a.length(); i++)
            sb.append("0");
        return sb.append(a).toString();
    }

    @Test
    public void test(){
        System.out.println(findDifferentBinaryString(new String[]{"000","001","110"}));
        System.out.println(findDifferentBinaryString(new String[]{"01","10"}));
        System.out.println(findDifferentBinaryString(new String[]{"00","01"}));
        System.out.println(findDifferentBinaryString(new String[]{"111","011","001"}));
    }
}
