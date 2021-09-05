package zContest;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _5863_CountSpecialQuadruplets {
    int result = 0;
    int cal = 0;
    int max = 0;
    public int countQuadruplets2(int[] nums) {
        result = 0;
        cal = 0;
        for(int n : nums) max = Math.max(max, n);
        List<List<Integer>> res = new ArrayList<>();
        combination2(nums, 0, 4, new ArrayList<Integer>(), res);
        System.out.println("cal : " + cal);
        return result;
    }

    public void combination2(int[] ar,int start, int pick, List<Integer> parent, List<List<Integer>> res){
        if( pick < 1){
            cal++;
            if(parent.get(3) == parent.get(0)+parent.get(1)+parent.get(2))
                result++;

            res.add(new ArrayList<>(parent));
            return;
        }

        for(int i = start; i<ar.length-(pick-1); i++){
           // if(i>0 && ar[i] == ar[i-1]) continue;
           if(pick>1 && ar[i] == max) continue; 
            parent.add(ar[i]);
            combination2(ar,i+1, pick-1, parent, res);
            parent.remove(parent.size()-1);
        }
        
    }

    public int countQuadruplets(int[] arr) {
        
        int i,j,k,n=arr.length,c=0;
        for(i=0;i<n-3;i++)
        {
            for(j=i+1;j<n-2;j++)
            {
                for(k=j+1;k<n-1;k++)
                {
                    for(int m=k+1;m<n;m++)
                    {
                       cal++;
                        if(arr[i]+arr[j]+arr[k]==arr[m])
                            c++;
                    }
                }
            }
        }
        System.out.println("cal : " + cal);
        return c;
    }

    @Test
    public void test(){
        System.out.println(countQuadruplets(new int[]{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
        System.out.println(countQuadruplets(new int[]{28,8,49,85,37,90,20,8}));
        System.out.println(countQuadruplets(new int[]{1,2,3,6}));
        System.out.println(countQuadruplets(new int[]{3,3,6,4,5}));
        System.out.println(countQuadruplets(new int[]{1,1,1,3,5}));
    }
}
