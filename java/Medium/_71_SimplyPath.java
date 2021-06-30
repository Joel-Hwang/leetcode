package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.testng.annotations.Test;

public class _71_SimplyPath {
    public String simplifyPath(String path) {
        ArrayList<String> lstPath = new ArrayList<String>();
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

    public String simplifyPath2(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");
        for (int i = 0; i < p.length; i++) {
            if (!stack.empty() && p[i].equals(".."))
                stack.pop();
            else if (!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
                stack.push(p[i]);
        }
        List<String> list = new ArrayList(stack);
        return "/"+String.join("/", list);
    }


    @Test
    public void test(){
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home/"));
    }
}
