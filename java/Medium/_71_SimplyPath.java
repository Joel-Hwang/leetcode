package Medium;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

public class _71_SimplyPath {
    public String simplifyPath(String path) {
        ArrayList<String> lstPath = new ArrayList<String>();
        path = path.replaceAll("/+", "/");
        String[] arPath = path.split("/");
        for(String s : arPath){
            if("".equals(s)) continue;
            if(".".equals(s)) continue;
            if("..".equals(s)){
                if(lstPath.size() >0)
                    lstPath.remove(lstPath.size()-1);
                continue;
            }

            lstPath.add(s);
            
        }

        StringBuilder sb = new StringBuilder();
        for(String s : lstPath){
            sb.append("/");
            sb.append(s);
        }
        return lstPath.size()==0?"/":sb.toString();
    }


    @Test
    public void test(){
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home/"));
    }
}
