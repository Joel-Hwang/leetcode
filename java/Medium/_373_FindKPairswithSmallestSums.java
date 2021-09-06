package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class _373_FindKPairswithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> row = new ArrayList();
        
        /*
        1. 남은 비교 인덱스들(i1,i2)를 넣을 리스트 생성
        2. 초기값으로 0,0을 res에 add
        3. 연산 리스트에 1,0과 0,1을 add
        4. k-1만큼 loop
        5. 연산 리스트에 있는 애들중 가장 작은 값을 추출
        6. 5의 결과를 res에 add
        7. 5의 i1, i2를 연산 리스트에서 삭제
        8. 연산 리스트에 i1+1, i2와 i1, i2+1을 add. (더할 때 이미 연산 리스트의 목록중 a<=i1, b<=i2+1이거나 a<=i1+1, b<=i2면 skip)
        
        */        
        //1. 남은 비교 인덱스들(i1,i2)를 넣을 리스트 생성
        List<List<Integer>> ops = new ArrayList();
        //2. 초기값으로 0,0을 res에 add
        int c1 = 0, c2 = 0;
        row.add(nums1[c1]);
        row.add(nums2[c2]);
        res.add(row);

        //3. 연산 리스트에 1,0과 0,1을 add
        {
            if(2 <nums2.length && alreadyExist(0, 1, ops)){
                List<Integer> opRow = new ArrayList();
                opRow.add(0);
                opRow.add(1);
                ops.add(opRow);
            }
            if(2 <nums1.length && alreadyExist(1, 0, ops)){
                List<Integer> opRow = new ArrayList();
                opRow.add(1);
                opRow.add(0);
                ops.add(opRow);
            }
        }

        //4. k-1만큼 loop
        for (int i = 1; i < k; i++) {
            //5. 연산 리스트에 있는 애들중 가장 작은 값을 추출
            int minI1 = nums1.length-1, minI2 = nums2.length-1;
            for (List<Integer> opRow : ops) {
                int i1 = opRow.get(0);
                int i2 = opRow.get(1);
                if(nums1[i1] + nums2[i2] <= nums1[minI1] + nums2[minI2] ){
                    minI1 = i1;
                    minI2 = i2;
                }
            }
            //6. 5의 결과를 res에 add
            row = new ArrayList();
            row.add(nums1[minI1]);
            row.add(nums2[minI2]);
            res.add(row);

            if(minI1 == nums1.length-1 && minI2 == nums2.length-1) break;

            //7. 5의 i1, i2를 연산 리스트에서 삭제
            for (int j = 0; j<ops.size(); j++) {
                if(ops.get(j).get(0)==minI1 && ops.get(j).get(1) == minI2){
                    ops.remove(j);
                }
            }
            //8. 연산 리스트에 i1+1, i2와 i1, i2+1을 add. 
            //(더할 때 이미 연산 리스트의 목록중 a<=i1, b<=i2+1이거나 a<=i1+1, b<=i2면 skip)
            //범위 벗어나도 skip
            if(minI2 <nums2.length-1 && alreadyExist(minI1, minI2+1, ops)){
                List<Integer> opRow = new ArrayList();
                opRow.add(minI1);
                opRow.add(minI2+1);
                ops.add(opRow);
            }
            if(minI1 <nums1.length-1 && alreadyExist(minI1+1, minI2, ops)){
                List<Integer> opRow = new ArrayList();
                opRow.add(minI1+1);
                opRow.add(minI2);
                ops.add(opRow);
            }
        }

        return res;
    }

    private boolean alreadyExist(int a, int b, List<List<Integer>> ops) {
        for (List<Integer> row : ops) {
            int i1 = row.get(0);
            int i2 = row.get(1);
            if (a >= i1 && b >= i2)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        List<List<Integer>> res = kSmallestPairs(new int[] { 1, 2 }, new int[] { 3 }, 3);
        for (List<Integer> row : res) {
            System.out.println(Arrays.toString(row.toArray()));
        }
    }
}
