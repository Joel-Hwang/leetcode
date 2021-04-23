package Hard;

public class _679_24Game {
    public _679_24Game() {
        System.out.println(judgePoint24(new int[]{4,1,8,7}));
    }

    public boolean judgePoint24(int[] nums) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    boolean res = getRes(nums[0], i, nums[1], j, nums[2], k, nums[3]);
                    if (res) return true;
                }
            }
        }

        return false;

    }

    private boolean getRes(int n1, int op1, int n2, int op2, int n3, int op3, int n4) {
        //abcd
        double res = cal(n1, op1, n2);
        res = cal(res, op2, n3);
        res = cal(res, op3, n4);
        if(res == 24) return true;

        //a(bc)d
        res = cal(n2,op2,n3);
        res = cal(n1,op1,res);
        res = cal(res,op3,n4);
        if(res == 24) return true;

        //ab(cd) and (ab)(cd)
        res = cal(n3,op3,n4);
        double res1 = cal(n1,op1,n2);
        res = cal(res1,op2,res);
        if(res == 24) return true;

         //a(bcd)
         res = cal(n2,op2,n3);
         res = cal(res,op3,n4);
         res = cal(n1,op1,res);
         if(res == 24) return true;

        return false;
    }

    private double cal(double n1, int op, double n2) {
        double res = 0;
        switch (op) {
        case 0:
            res = n1 + n2;
            break;
        case 1:
            res = n1 - n2;
            break;
        case 2:
            res = n1 * n2;
            break;
        case 3:
            res = n1 / n2;
            break;
        }
        return res;
    }

}