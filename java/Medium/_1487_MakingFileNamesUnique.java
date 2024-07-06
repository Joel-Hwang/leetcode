package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _1487_MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        String[] result = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<names.length; i++){
            String newName = names[i];
            while(map.containsKey(newName)){
                int k = map.get(names[i]);
                k++;
                map.put(names[i], k);
                StringBuilder sb = new StringBuilder(names[i]);
                sb.append("(");
                sb.append(k);
                sb.append(")");
                
                newName = sb.toString();
            }

            result[i] = newName;
            map.put(newName, 0);
            
        }

        return result;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(getFolderNames(new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"})));
        System.out.println(Arrays.toString(getFolderNames(new String[]{"gta","gta(1)","gta","avalon"})));
    }
}
