package Hard;

public class _1012_NumbersWithRepeatedDigits {
    public int numDupDigitsAtMostN(int n) {
        int res = 0;
        for(int i = 1; i<=n; i++)
            if(isDup(i)) res++;
        return res;
    }

    private boolean isDup(int n){
        int[] ar = new int[10];
        while(n > 0){
            ar[n%10]++;
            n /= 10;
        }
        for(int a : ar) if(a>1) return true;
        return false;
    }
}
