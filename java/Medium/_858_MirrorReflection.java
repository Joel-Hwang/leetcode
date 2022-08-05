package Medium;

public class _858_MirrorReflection {
    public int mirrorReflection(int p, int q) {
        while(p%2==0 && q %2==0){
            p = p >> 1;
            q = q >> 1;
        }
        if(p%2 == 1 && q%2==1) return 1;
        if(p%2 == 1 && q%2 ==0) return 0;
        return 2;
    }
}
