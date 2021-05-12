package Easy;

public class _693_BinaryNumberWithAlternatingBits {
    public _693_BinaryNumberWithAlternatingBits(){
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(10));
        System.out.println(hasAlternatingBits(3));
    }


    public boolean hasAlternatingBits(int n) {
        int lastMod = -1;
        while(n>0){
            int mod = n%2;
            n /=2;
            if(lastMod == mod ) return false;
            else lastMod = mod;
        }
        return true;
    }
}
