import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        swap("1234",1,3);
    }

    public static void swap(String str , int s, int e){
        StringBuilder sb = new StringBuilder(str);
        char temp = sb.charAt(e); 
        sb.delete(e, e+1);
        sb.insert(s, temp);
        System.out.println(sb);

        sb.delete(s,s+1);
        sb.insert(e, temp);
        System.out.println(sb);
    }
}