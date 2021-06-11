package Easy;

import org.testng.annotations.Test;

public class PrintStream {
    
    public void print(String[] ar, int cnt) {
        for (int i = 0; i < ar.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < ar.length && j < i + cnt; j++) {
                sb.append(" ").append(ar[j]);
                System.out.println(sb.substring(1));
            }
        }
    } 
    
    @Test
    public void test() {
        print("spring book 1 view, gold book self, new hope club".split(" "), 3);
    }
}
