package Hard;

import java.util.Stack;
import  java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.testng.annotations.Test;

public class _591_TagValidator {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        int n = code.length();

        while (i < n) {
            if (i > 0 && stack.isEmpty()) {
                return false; // Not wrapped in a valid closed tag
            }

            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0) {
                    return false; // CDATA section is not closed
                }
                i += 3; // Skip the "]]>" part
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf('>', j);
                if (i < 0) {
                    return false; // End tag is not closed
                }
                String tagName = code.substring(j, i);
                if (stack.isEmpty() || !stack.pop().equals(tagName)) {
                    return false; // Tag mismatch or stack underflow
                }
                i++; // Move past '>'
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf('>', j);
                if (i < 0) {
                    return false; // Start tag is not closed
                }
                String tagName = code.substring(j, i);
                if (!isValidTagName(tagName)) {
                    return false; // Invalid tag name
                }
                stack.push(tagName);
                i++; // Move past '>'
            } else {
                i++;
            }
        }

        return stack.isEmpty(); // All tags should be closed properly
    }

    private boolean isValidTagName(String tagName) {
        int len = tagName.length();
        if (len < 1 || len > 9) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            char c = tagName.charAt(i);
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test(){
        String s ="<DIV>This is the first line <![CDATA[<div>]]></DIV> <DIV>This is the first line <![CDATA[<div>]]></DIV> <DIV>This is the first line <![CDATA[<div>]]></DIV>";
        String cdataRegex = "<!\\[CDATA\\[(.*?)\\]\\]>";
        Pattern pattern = Pattern.compile(cdataRegex);
        Matcher matcher = pattern.matcher(s);
        
        while (matcher.find()) {
            System.out.println("Found CDATA section: " + matcher.group(1));
            int start = matcher.start();
            int end = matcher.end();
        }
    }
}
