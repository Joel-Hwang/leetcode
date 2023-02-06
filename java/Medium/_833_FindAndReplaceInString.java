package Medium;

import java.util.HashMap;

import org.testng.annotations.Test;

public class _833_FindAndReplaceInString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, String> sMap = new HashMap<>();
        HashMap<Integer, String> tMap = new HashMap<>();
        for(int i = 0; i<indices.length; i++){
            sMap.put(indices[i], sources[i]);
            tMap.put(indices[i], targets[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(!sMap.containsKey(i)) continue;
            
            int lastIdx = i + sMap.get(i).length();
            if(lastIdx > s.length()) continue;
            if(s.substring(i, lastIdx ).equals(sMap.get(i))){
                sb.deleteCharAt(sb.length()-1);
                sb.append(tMap.get(i));
                i += sMap.get(i).length()-1;
            }
        }
        
        return sb.toString();
    }

    public String findReplaceString3(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, String> sMap = new HashMap<>();
        HashMap<Integer, String> tMap = new HashMap<>();
        for(int i = 0; i<indices.length; i++){
            sMap.put(indices[i], sources[i]);
            tMap.put(indices[i], targets[i]);
        }

        for(int i = s.length()-1; i>=0; i--){
            if(!sMap.containsKey(i)) continue;
            int lastIdx = i + sMap.get(i).length();
            if(lastIdx > s.length()) continue;
            if(s.substring(i, lastIdx ).equals(sMap.get(i))){
                s = s.subSequence(0, i) + tMap.get(i) + s.substring(lastIdx);
            }

        }
        
        return s;
    }
    public String findReplaceString2(String s, int[] indices, String[] sources, String[] targets) {
        for(int i = 0; i<indices.length-1; i++)
            for(int j = i+1; j<indices.length; j++)
                if(indices[i] < indices[j]){
                    int temp = indices[i];
                    indices[i] = indices[j];
                    indices[j] = temp;

                    String strTemp = sources[i];
                    sources[i] = sources[j];
                    sources[j] = strTemp;
                    strTemp = targets[i];
                    targets[i] = targets[j];
                    targets[j] = strTemp;
                }

        for(int i = 0; i<indices.length; i++){
            int lastIdx = indices[i] + sources[i].length();
            if(lastIdx > s.length()) continue;
            if(s.substring(indices[i], lastIdx ).equals(sources[i])){
                s = s.subSequence(0, indices[i]) + targets[i] + s.substring(lastIdx);
            }
        }    
        
        return s;
    }

    @Test
    public void test(){
        System.out.println(findReplaceString("abcde", new int[]{2,2}, new String[]{"cdef","bc"}, new String[]{"f","fe"}));
        System.out.println(findReplaceString("abcd", new int[]{0,2}, new String[]{"a","cd"}, new String[]{"eee","ffff"}));
        System.out.println(findReplaceString("abcd", new int[]{0,2}, new String[]{"ab","ec"}, new String[]{"eee","ffff"}));
    }

    
}
