package Easy;

import java.util.*;

import org.testng.annotations.Test;

public class _1175_PrimeArrangements {
    public int numPrimeArrangements(int n) {
        List<Integer> primes = getPrimes(n);
        long res = 1;
        for(int i = 2; i<=primes.size(); i++) res = (res*i)%1000000007;
        for(int i = 2; i<=n-primes.size(); i++) res = (res*i)%1000000007;
        return (int)res;
    }

    private List<Integer> getPrimes(int n){
        List<Integer> res = new ArrayList<Integer>();

        for(int i = 2; i<=n; i++)
            if(isPrime(i))
                res.add(i);
        return res;
    }
    
    private boolean isPrime(int n){
        for(int i = 2; i<=Math.sqrt(n); i++)
            if(n%i==0) return false;
        return true;
    }

   


   

    @Test
    public void test(){
        System.out.println(numPrimeArrangements(100));
        System.out.println(numPrimeArrangements(5));
    }
}
