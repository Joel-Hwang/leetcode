package Hard;

import java.util.PriorityQueue;
import org.testng.annotations.Test;

public class _1675_MinimizeDeviationinArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        int mi = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int n : nums){
            if(n%2 == 1) n = n*2;  //작은 홀수들은 2를 곱하면서 gap을 줄일수 있고 큰 숫자들은 2로 곱해서 넣어도 나중에 /2 하면서 원복 되기 때문임. 작은 숫자 *2 하려는 목적

            //poll 했을 때 제일 큰 숫자 나오게 하려고 -로 붙임 - 하기 싫으면 큐 만들 때 리버스로 만들면 됨
            qu.offer(-n);

            //최소값 찾기
            mi = Math.min(mi, n);
        }

        while(true){
            //현재 최대값 뽑기
            int max = -qu.poll();
            //최대 최소 차이 업데이트
            res = Math.min(res, max-mi);
            //최대값이 홀수면 갭을 줄일 수 없으니 그대로 리턴
            if(max%2 == 1) return res;

            //최대값이 짝수면 2로 나눠보고 최소값 갱신. 
            mi = Math.min(mi, max/2);
            //2로 나눈걸 다시 큐에 넣음
            qu.offer(-max/2);
        }
    }

    @Test
    public void test(){
        System.out.println(minimumDeviation(new int[]{1,2,3,4}));
    }
}
