package Hard;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _68_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int len = 0;
        List<String> line = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            int wordLen = getWordLen(line,words[i]);
            if(len + wordLen<=maxWidth){
                line.add(words[i]);
                len +=wordLen;
            }else{
                //line을 justify해서 res에 넣고
                res.add(line.size()>1?
                fullyJustify(line,maxWidth,len):leftJustify(line, maxWidth));
                line = new ArrayList<>();
                len = 0;
                i--;
            }
        }

        //line leftJustfity
        res.add(leftJustify(line,maxWidth));

        return res;
    }

    private int getWordLen(List<String> line, String word){
        if(line.isEmpty()) return word.length();
        else return word.length()+1;
    }

    private String fullyJustify(List<String> line, int maxWidth, int len){
        StringBuilder res = new StringBuilder();
        float ws = maxWidth - len + line.size() -1;
        int ls = line.size()-1;
        for(String s : line){
            res.append(s);
            int curWs = ls==0?0:(int)Math.ceil(ws/ls);
            for(int i = 0; i<curWs; i++) res.append(" ");
            ws -= curWs;
            ls--;
        }
        return res.toString();
    }

    private String leftJustify(List<String> line, int maxWidth){
        StringBuilder res = new StringBuilder();
        int curLen = 0;
        for(int i = 0; i<line.size()-1; i++){
            res.append(line.get(i));
            res.append(" ");
            curLen += (line.get(i).length()+1);
        }

        res.append(line.get(line.size()-1));
        curLen += line.get(line.size()-1).length();
        for(int i = 0; i<maxWidth - curLen; i++) res.append(" ");

        return res.toString();
    }


    @Test
    public void test(){

        for(String s : fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16)) System.out.println(s);
        for(String s : fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16)) System.out.println(s);
        for(String s : fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"},20)) System.out.println(s);

    }
}
