package Hard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _65_ValidNumber{
    public boolean isNumber(String s) {
        int i = 0;
        char[] arC = s.toCharArray();
        if("-.".equals(s)) return false;
        if("+.".equals(s)) return false;
        if(".".equals(s)) return false;
        if(s.toLowerCase().startsWith(".e")) return false;
        if(arC.length == 0) return false;
        if(arC[0] == 'e' || arC[0] == 'E') return false;
        if(arC[arC.length-1] == 'e' || arC[arC.length-1] == 'E') return false;
        if(arC[arC.length-1] == '+' || arC[arC.length-1] == '-') return false;
        if(arC[0] == '+' || arC[0] == '-') i = 1;
        boolean isE = false;
        boolean isDot = false;
        for(i=i; i<arC.length; i++){
            if(!"0123456789.eE+-".contains(""+arC[i])) return false;
            
            if(arC[i] == '.'){
                if(isDot) return false; 
                if(isE) return false;
                if(i+1<arC.length && (arC[i+1] == '+'|| arC[i+1] == '-') ) return false;
                isDot = true;
            }
            
            
            if(arC[i]=='e' || arC[i]=='E'){
                if(!"0123456789.".contains(""+arC[i-1])) return false;
                if(!"0123456789+-".contains(""+arC[i+1])) return false;
                if(isE) return false;
                isE = true;
            }

            if( (arC[i]=='+' || arC[i]=='-') 
            && (arC[i-1]=='+' || arC[i-1]=='-' || "0123456789".contains(""+arC[i-1]))){
                 return false;
            }
           
        }
        return true;
    }
    /*
    We start with trimming.

If we see [0-9] we reset the number flags.
We can only see . if we didn't see e or ..
We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
We can only see + and - in the beginning and after an e
any other character break the validation.
At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.

So basically the number should match this regular expression:

[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
    */
    public boolean isNumber2(String s) {
        s = s.trim();
        
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return numberSeen && numberAfterE;
    }

    @Test
    public void test(){
        assertFalse(isNumber("92e1740e91"));
        assertFalse(isNumber(".e1"));
        assertTrue(isNumber("46.e3"));
        assertFalse(isNumber("-."));
        assertFalse(isNumber(".-4"));
        assertFalse(isNumber("+."));
        assertFalse(isNumber("4e+"));
        assertFalse(isNumber("6+1"));
        assertFalse(isNumber(".1."));
        assertTrue(isNumber(".1"));
        assertFalse(isNumber("."));
        assertFalse(isNumber("e"));
        assertFalse(isNumber(".."));
        assertTrue(isNumber(".1"));
        assertTrue(isNumber("0"));
        assertTrue(isNumber("2"));
        assertTrue(isNumber("0089"));
        assertTrue(isNumber("-0.1"));
        assertTrue(isNumber("+3.14"));
        assertTrue(isNumber("4."));
        assertTrue(isNumber("-.9"));
        assertTrue(isNumber("2e10"));
        assertTrue(isNumber("-90E3"));
        assertTrue(isNumber("3e+7"));
        assertTrue(isNumber("+6e-1"));
        assertTrue(isNumber("53.5e93"));
        assertTrue(isNumber("-123.456e789"));
        assertFalse(isNumber("abc"));
        assertFalse(isNumber("1a"));
        assertFalse(isNumber("1e"));
        assertFalse(isNumber("e3"));
        assertFalse(isNumber("99e2.5"));
        assertFalse(isNumber("--6"));
        assertFalse(isNumber("-+3"));
        assertFalse(isNumber("95a54e53"));
    }
}