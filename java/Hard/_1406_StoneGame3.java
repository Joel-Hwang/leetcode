package Hard;

import org.testng.annotations.Test;

public class _1406_StoneGame3 {
    public String stoneGameIII(int[] A) {
        int alice = 0;
        int bob = 0;
        int turn = 0;

        for (int i = 0; i < A.length; i++) {
            // A[0] : max(A[1] , A[1]+A[2], A[1]+A[2]+A[3])
            // A[0]+A[1] : max(A[2] , A[2]+A[3], A[2]+A[3]+A[4])
            // A[0]+A[1]+A[2] : max(A[3] , A[3]+A[4], A[3]+A[4]+A[5])
            int nextI = i;

            int expMe1 = A[i];
            int expEnemy1 = getExpEnemy(A, i);
            int gap1 = expMe1 - expEnemy1;

            // 2번째 요소가 배열 범위 밖이면 Skip
            if (i + 2 < A.length) {
                int expMe2 = A[i] + A[i + 1];
                int expEnemy2 = getExpEnemy(A, i + 1);
                int gap2 = expMe2 - expEnemy2;

                if (gap1 < gap2) {
                    gap1 = gap2;
                    expMe1 = expMe2;
                    nextI = i + 1;
                }
            }
            // 3번째 요소가 배열 범위 밖이면 Skip
            if (i + 2 < A.length) {
                int expMe3 = A[i] + A[i + 1] + A[i + 2];
                int expEnemy3 = getExpEnemy(A, i + 2);
                int gap3 = expMe3 - expEnemy3;

                if (gap1 < gap3) {
                    gap1 = gap3;
                    expMe1 = expMe3;
                    nextI = i + 2;
                }
            }

            if (turn % 2 == 0)
                alice += expMe1;
            else
                bob += expMe1;
            i = nextI;
            turn++;
        }
        
        if(alice == bob) return "Tie";
        if(alice > bob) return "Alice";
        else return "Bob";
    }

    private int getExpEnemy(int[] A, int i) {
        if (i >= A.length - 1)
            return Integer.MAX_VALUE;
        int expEnemy = A[i + 1]; // 내 다음부터 선택
        for (int j = i + 2; j < i + 4 && j < A.length; j++) { // 내 다음부터 3개까지 선택 가능
            // 상대가 고를 수 있는 최적 값
            expEnemy = Math.max(expEnemy, expEnemy + A[j]);
        }
        return expEnemy;
    }


    @Test
    public void test(){
        System.out.println(stoneGameIII(new int[]{-1,-2,-3}));
        System.out.println(stoneGameIII(new int[]{1,2,3,-1,-2,-3,7}));
        System.out.println(stoneGameIII(new int[]{1,2,3,6}));
        System.out.println(stoneGameIII(new int[]{1,2,3,-9}));
        System.out.println(stoneGameIII(new int[]{1,2,3,7}));
    }

}